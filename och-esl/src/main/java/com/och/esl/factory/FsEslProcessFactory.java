package com.och.esl.factory;

import com.och.common.annotation.EslProcessName;
import com.och.common.enums.ProcessEnum;
import com.och.esl.handler.call.FsAbstractCallProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author danmo
 * @date 2023年09月18日 19:03
 */
@Slf4j
@Component
public class FsEslProcessFactory {

    private final Map<String, FsAbstractCallProcess> callProcessMap = new ConcurrentHashMap<>(16);

    public FsEslProcessFactory(Map<String, FsAbstractCallProcess> callProcessMap) {
        this.callProcessMap.putAll(callProcessMap);
    }

    public FsAbstractCallProcess factory(ProcessEnum processEnum) {
        for (FsAbstractCallProcess handler : callProcessMap.values()) {
            EslProcessName processName = handler.getClass().getAnnotation(EslProcessName.class);
            if (processName == null) {
                processName = handler.getClass().getSuperclass().getAnnotation(EslProcessName.class);
            }
            if (Objects.equals(processEnum, processName.value())) {
                return handler;
            }
        }
        return null;
    }

}
