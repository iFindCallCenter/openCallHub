package com.och.esl.handler.esl;

import com.alibaba.fastjson.JSONObject;
import com.och.common.annotation.EslEventName;
import com.och.common.constant.EslEventNames;
import com.och.common.domain.CallInfo;
import com.och.common.domain.ChannelInfo;
import com.och.common.enums.AgentStateEnum;
import com.och.common.enums.DirectionEnum;
import com.och.esl.factory.AbstractFsEslEventHandler;
import com.och.esl.utils.EslEventUtil;
import lombok.extern.slf4j.Slf4j;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 桥接调用
 * @author danmo
 * @date 2023年09月18日 19:03
 */
@Slf4j
@EslEventName(EslEventNames.CHANNEL_BRIDGE)
@Component
public class FsChannelBridgeEslEventHandler extends AbstractFsEslEventHandler {

    @Override
    public void handleEslEvent(String address, EslEvent event) {
        log.info("ChannelBridgeEslEventHandler EslEvent:{}.", JSONObject.toJSONString(event));
        String uniqueId = EslEventUtil.getUniqueId(event);
        String otherUniqueId = EslEventUtil.getOtherUniqueId(event);
        CallInfo callInfo = ifsCallCacheService.getCallInfoByUniqueId(uniqueId);
        if(Objects.isNull(callInfo)){
            return;
        }
        if (callInfo.getAnswerTime() == null || callInfo.getAnswerTime() == 0L) {
            callInfo.setAnswerTime(event.getEventDateTimestamp() / 1000);
           /* if (callInfo.getHiddenCustomer() == 1) {
                //隐藏客户侧号码
                if (Objects.equals(DirectionEnum.INBOUND.getType(), callInfo.getDirection())) {

                } else if (Objects.equals(DirectionEnum.OUTBOUND.getType(), callInfo.getDirection())) {

                }
            }*/
        }
        log.info("桥接成功 callId:{}, uniqueId:{}, otherUniqueId:{}", callInfo.getCallId(), uniqueId, otherUniqueId);
        ChannelInfo channelInfo = callInfo.getChannelMap().get(uniqueId);
        ChannelInfo otherChannelInfo = callInfo.getChannelMap().get(otherUniqueId);
        if (channelInfo != null && channelInfo.getBridgeTime() == null) {
            channelInfo.setBridgeTime(event.getEventDateTimestamp() / 1000);
        }
        if (otherChannelInfo != null && otherChannelInfo.getBridgeTime() == null) {
            otherChannelInfo.setBridgeTime(event.getEventDateTimestamp() / 1000);
        }

        fsClient.detectSpeech(address,callInfo.getCallId(),uniqueId);
        fsClient.detectSpeech(address,callInfo.getCallId(),otherUniqueId);

        callInfo.setChannelInfoMap(uniqueId,channelInfo);
        callInfo.setChannelInfoMap(otherUniqueId,otherChannelInfo);
        ifsCallCacheService.saveCallInfo(callInfo);

        sendAgentStatus(callInfo.getCallId(),callInfo.getCaller(),callInfo.getCallee(),callInfo.getDirection(), AgentStateEnum.TALKING);
        /*if(!callInfo.getRecord().isEmpty()){
            ThreadUtil.execAsync(() ->{
                try {
                    SpeechClient speechClient = TxSpeechClient.getSpeechClient(lfsTxSpeechProperties.getAppKey(), lfsTxSpeechProperties.getAccessKeyId(), lfsTxSpeechProperties.getAccessKeySecret());
                    TxSpeechClient.runOnce(speechClient,callInfo.getCallId(),"http://" + address.split(":")[0] + "/linkFs" + callInfo.getRecord());
                } catch (IOException e) {
                    log.error(e.getMessage(),e);
                }

                //SpringUtil.getBean(AliNlsClient.class).process(callInfo.getCallId(),"http://" + address.split(":")[0] + "/linkFs" + callInfo.getRecord());
            });
        }*/
    }
}
