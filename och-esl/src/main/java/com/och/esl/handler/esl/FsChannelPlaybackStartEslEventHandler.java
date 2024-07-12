
package com.och.esl.handler.esl;

import com.alibaba.fastjson.JSONObject;
import com.och.common.annotation.EslEventName;
import com.och.common.constant.EslEventNames;
import com.och.esl.factory.AbstractFsEslEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.springframework.stereotype.Component;

/**
 * 放音开始
 * @author danmo
 * @date 2023年09月18日 19:03
 */
@Slf4j
@EslEventName(EslEventNames.PLAYBACK_START)
@Component
public class FsChannelPlaybackStartEslEventHandler extends AbstractFsEslEventHandler {

    @Override
    public void handleEslEvent(String address, EslEvent event) {
        log.info("放音开始 EslEvent:{}.", JSONObject.toJSONString(event));
    }
}
