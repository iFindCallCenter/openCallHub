
package com.och.esl.handler.esl;

import com.och.common.annotation.EslEventName;
import com.och.common.constant.EslEventNames;
import com.och.esl.factory.AbstractFsEslEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.springframework.stereotype.Component;

/**
 * 渠道挂机处理类
 * @author danmo
 * @date 2023年09月18日 19:03
 */
@Slf4j
@EslEventName(EslEventNames.CHANNEL_HANGUP)
@Component
public class FsChannelHangUpEslEventHandler extends AbstractFsEslEventHandler {

    @Override
    public void handleEslEvent(String address, EslEvent event) {
        //log.info("ChannelHangUpEslEventHandler EslEvent:{}.", JSONObject.toJSONString(event));

    }
}
