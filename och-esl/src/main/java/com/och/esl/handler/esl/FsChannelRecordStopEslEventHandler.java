
package com.och.esl.handler.esl;

import com.alibaba.fastjson.JSONObject;
import com.och.common.annotation.EslEventName;
import com.och.common.constant.EslEventNames;
import com.och.common.domain.CallInfo;
import com.och.esl.factory.AbstractFsEslEventHandler;
import com.och.esl.utils.EslEventUtil;
import lombok.extern.slf4j.Slf4j;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.springframework.stereotype.Component;

/**
 * 结束录音
 * @author danmo
 * @date 2023年09月18日 19:03
 */
@Slf4j
@EslEventName(EslEventNames.RECORD_STOP)
@Component
public class FsChannelRecordStopEslEventHandler extends AbstractFsEslEventHandler {

    @Override
    public void handleEslEvent(String address, EslEvent event) {
        log.info("LfsChannelRecordStopEslEventHandler EslEvent:{}.", JSONObject.toJSONString(event));
        String uniqueId = EslEventUtil.getUniqueId(event);
        CallInfo callInfo = ifsCallCacheService.getCallInfoByUniqueId(uniqueId);
        if (callInfo == null) {
            return;
        }
        callInfo.setRecordEndTime(event.getEventDateTimestamp() / 1000);
        callInfo.setRecordTime(callInfo.getRecordEndTime() - callInfo.getRecordStartTime());
        ifsCallCacheService.saveCallInfo(callInfo);
    }
}
