package com.och.esl.service.impl;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import com.och.common.utils.StringUtils;
import com.och.esl.FsEslEventRunnable;
import com.och.esl.FsEslMsg;
import com.och.esl.factory.FsEslEventFactory;
import com.och.esl.service.IFsEslEventService;
import com.och.esl.utils.EslEventUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author danmo
 * @date 2023-10-20 10:46
 **/
@Slf4j
@Service
public class IFsEslEventServiceImpl implements IFsEslEventService, InitializingBean {


    @Value("${freeswitch.thread-num:64}")
    private Integer threadNum;


    @Autowired
    private FsEslEventFactory factory;

    private final Map<Integer, ThreadPoolExecutor> executorMap = new ConcurrentHashMap<>();


    @Override
    public void eslEventPublisher(FsEslMsg msg) {
        ExecutorService executorService = getExecutorService(msg.getEslEvent());
        executorService.execute(new FsEslEventRunnable(factory,msg));
    }


    @Override
    public void destroyThreadPool() {
        executorMap.values().forEach(pool -> {
            if (pool != null && !pool.isShutdown())
            {
                pool.shutdown();
                try
                {
                    if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    {
                        pool.shutdownNow();
                    }
                }
                catch (InterruptedException ie)
                {
                    pool.shutdownNow();
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (int i = 0; i < threadNum; i++) {
            ThreadPoolExecutor singleExecutor = new ThreadPoolExecutor(1, 1,
                    0L, TimeUnit.MILLISECONDS,
                    new ArrayBlockingQueue<>(10000),
                    new ThreadFactoryBuilder().setNamePrefix("esl-customer-pool-" + i + "-").build(),
                    (Runnable r, ThreadPoolExecutor executor) -> {
                        if (r instanceof FsEslEventRunnable fsEslEventRunnable) {
                            EslEvent eslEvent = fsEslEventRunnable.getMsg().getEslEvent();
                            log.error("线程池队列已满 拒绝策略触发 ->{}, {}", eslEvent.getEventName(), EslEventUtil.getUniqueId(eslEvent));
                            try {
                                //等待1秒后，尝试将当前被拒绝的任务重新加入线程队列
                                Thread.sleep(1000);
                                log.error("尝试重新加入 ->{}, {}", eslEvent.getEventName(), EslEventUtil.getUniqueId(eslEvent));
                                executor.execute(r);
                            } catch (Exception e) {
                            }
                        }
                    });
            executorMap.put(i, singleExecutor);
        }
    }


    private ExecutorService getExecutorService(EslEvent eslEvent) {
        ExecutorService executorService = null;
        if (StringUtils.isEmpty(EslEventUtil.getUniqueId(eslEvent))) {
            executorService = executorMap.get(RandomUtils.nextInt(0, threadNum));
        } else {
            int coreHash = EslEventUtil.getUniqueId(eslEvent).hashCode();
            executorService = executorMap.get(Math.abs(coreHash % threadNum));
        }
        return executorService;
    }


}
