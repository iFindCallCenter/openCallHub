
package com.och.esl.handler.esl;

import com.alibaba.fastjson.JSONObject;
import com.och.common.annotation.EslEventName;
import com.och.common.constant.EslEventNames;
import com.och.common.domain.CallInfo;
import com.och.common.domain.ChannelInfo;
import com.och.esl.factory.AbstractFsEslEventHandler;
import com.och.esl.handler.call.FsAbstractCallProcess;
import com.och.esl.utils.EslEventUtil;
import lombok.extern.slf4j.Slf4j;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 渠道回答处理类
 * @author danmo
 * @date 2023年09月18日 19:03
 */
@Slf4j
@EslEventName(EslEventNames.CHANNEL_ANSWER)
@Component
public class FsChannelAnswerEslEventHandler extends AbstractFsEslEventHandler {

    @Override
    public void handleEslEvent(String address, EslEvent event) {
        log.info("ChannelAnswerEslEventHandler handle address:{} EslEvent:{}.", address, JSONObject.toJSONString(event));
        String uniqueId = EslEventUtil.getUniqueId(event);
        CallInfo callInfo = ifsCallCacheService.getCallInfoByUniqueId(uniqueId);
        if(Objects.isNull(callInfo)){
            return;
        }
        ChannelInfo channelInfo = callInfo.getChannelMap().get(uniqueId);
        channelInfo.setAnswerTime(event.getEventDateTimestamp()/1000);
        channelInfo.setRingEndTime(event.getEventDateTimestamp() / 1000);
        callInfo.setAnswerCount(callInfo.getAnswerCount() + 1);
        FsAbstractCallProcess factory = fsEslProcessFactory.factory(callInfo.getProcess());
        try {
            factory.handler(address,event,callInfo,channelInfo);
        } catch (Exception e) {
            log.error("应答处理类执行异常 callId:{}", callInfo.getCallId(), e);
        }
    }
}
