
package com.och.esl.handler.esl;

import com.och.common.annotation.EslEventName;
import com.och.common.constant.EslEventNames;
import com.och.esl.factory.AbstractFsEslEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.springframework.stereotype.Component;

/**
 * 对于呼出呼叫，另一方处于响铃状态；对于呼入电话，该方正在进行提醒。
 * @author danmo
 * @date 2023年09月18日 19:03
 */
@Slf4j
@EslEventName(EslEventNames.CHANNEL_PROGRESS)
@Component
public class FsChannelProgressEslEventHandler extends AbstractFsEslEventHandler {

    @Override
    public void handleEslEvent(String address, EslEvent event) {
        //log.info("ChannelProgressEslEventHandler handle address:{} EslEvent:{}.", address, JSONObject.toJSONString(event));
    }
}
