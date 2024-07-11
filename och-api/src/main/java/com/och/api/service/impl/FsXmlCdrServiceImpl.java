package com.och.api.service.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.och.api.service.IFsXmlCdrService;
import com.och.common.config.redis.RedisService;
import com.och.common.constant.CacheConstants;
import com.och.common.domain.CallInfo;
import com.och.common.domain.Cdr;
import com.och.common.exception.ParserException;
import com.och.common.parser.CdrParser;
import com.och.common.utils.StringUtils;
import com.och.system.domain.entity.FsCdr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Slf4j
@Service
public class FsXmlCdrServiceImpl implements IFsXmlCdrService {


    @Autowired
    private RedisService redisService;

    @Async
    @Override
    public void cdrHandler(String reqText) throws ParserException {
        Cdr cdr = CdrParser.decodeThenParse(reqText);
        log.info("cdr 消息：{}", JSONObject.toJSONString(cdr));
        FsCdr fsCdr = parseToCdr(cdr);
        if (Objects.nonNull(fsCdr)) {

            CallInfo callInfo = getCallInfo(fsCdr.getCallId());
            if (Objects.nonNull(callInfo)) {
                if (callInfo.getRecordEndTime() != null) {
                    fsCdr.setRecordEndTime(new Date(callInfo.getRecordEndTime()));
                }

            }

            //保存
            //fsConfigClient.addCdrInfo(lfsCdr);


            //话单通知
            String cdrNotifyUrl = fsCdr.getCdrNotifyUrl();

            removeCallInfo(fsCdr.getCallId());
        }
    }

    private FsCdr parseToCdr(Cdr cdr) {
        String uuid = cdr.getVariables().getVariableTable().get("uuid");

        CallInfo callInfo = getCallInfoByUniqueId(uuid);
        if (Objects.isNull(callInfo)) {
            return null;
        }
        Long callId = callInfo.getCallId();

        FsCdr lfsCdr = new FsCdr();

        lfsCdr.setCallId(callId);
        lfsCdr.setUuid(uuid);
        lfsCdr.setPayload(JSONObject.toJSONString(callInfo.getChannelMap()));
        lfsCdr.setCdrNotifyUrl(callInfo.getCdrNotifyUrl());
        if (callInfo.getRecordStartTime() != null) {
            lfsCdr.setRecordStartTime(new Date(callInfo.getRecordStartTime()));
        }
        if (callInfo.getRecordEndTime() != null) {
            lfsCdr.setRecordEndTime(new Date(callInfo.getRecordEndTime()));
        }
        if (callInfo.getRecordTime() != null) {
            lfsCdr.setRecordSec(callInfo.getRecordTime().intValue());
        } else if (StringUtils.isNotBlank(cdr.getVariables().getVariableTable().get("record_seconds"))) {
            lfsCdr.setRecordSec(Integer.valueOf(cdr.getVariables().getVariableTable().get("record_seconds")));
        }

        lfsCdr.setRecord(callInfo.getRecord());
        switch (callInfo.getDirection()) {
            case 1:
                lfsCdr.setDirection("inbound");
                break;
            case 2:
                lfsCdr.setDirection("outbound");
                break;
            default:
                lfsCdr.setDirection(cdr.getVariables().getVariableTable().get("direction"));
                break;
        }
        //lfsCdr.setDirection(cdr.getVariables().getVariableTable().get("direction"));
        lfsCdr.setSipLocalNetworkAddr(cdr.getVariables().getVariableTable().get("sip_local_network_addr"));
        lfsCdr.setSipNetworkIp(cdr.getVariables().getVariableTable().get("sip_network_ip"));
        lfsCdr.setCallerIdNumber(callInfo.getCaller());
        lfsCdr.setCallerDisplay(callInfo.getCallerDisplay());
        lfsCdr.setDestinationNumber(callInfo.getCallee());
        lfsCdr.setDestinationDisplay(callInfo.getCalleeDisplay());
        if (StringUtils.isNotBlank(cdr.getVariables().getVariableTable().get("start_stamp"))) {
            lfsCdr.setStartStamp(DateUtil.parseDateTime(cdr.getVariables().getVariableTable().get("start_stamp")));
        }
        if (StringUtils.isNotBlank(cdr.getVariables().getVariableTable().get("answer_stamp"))) {
            lfsCdr.setAnswerStamp(DateUtil.parseDateTime(cdr.getVariables().getVariableTable().get("answer_stamp")));
        }
        if (StringUtils.isNotBlank(cdr.getVariables().getVariableTable().get("end_stamp"))) {
            lfsCdr.setEndStamp(DateUtil.parseDateTime(cdr.getVariables().getVariableTable().get("end_stamp")));
        }
        if (StringUtils.isNotBlank(cdr.getVariables().getVariableTable().get("progress_stamp"))) {
            lfsCdr.setProgressStamp(DateUtil.parseDateTime(cdr.getVariables().getVariableTable().get("progress_stamp")));
        }
        if (StringUtils.isNotBlank(cdr.getVariables().getVariableTable().get("bridge_stamp"))) {
            lfsCdr.setBridgeStamp(DateUtil.parseDateTime(cdr.getVariables().getVariableTable().get("bridge_stamp")));
        }
        if (StringUtils.isNotBlank(cdr.getVariables().getVariableTable().get("duration"))) {
            lfsCdr.setDuration(Integer.valueOf(cdr.getVariables().getVariableTable().get("duration")));
        }
        if (StringUtils.isNotBlank(cdr.getVariables().getVariableTable().get("answersec"))) {
            lfsCdr.setAnswerSec(Integer.valueOf(cdr.getVariables().getVariableTable().get("answersec")));
        }
        if (StringUtils.isNotBlank(cdr.getVariables().getVariableTable().get("billsec"))) {
            lfsCdr.setBillSec(Integer.valueOf(cdr.getVariables().getVariableTable().get("billsec")));
        }
        lfsCdr.setHangupCause(cdr.getVariables().getVariableTable().get("hangup_cause"));
        lfsCdr.setReadCodec(cdr.getVariables().getVariableTable().get("read_codec"));
        lfsCdr.setWriteCodec(cdr.getVariables().getVariableTable().get("write_codec"));
        lfsCdr.setSipHangupDisposition(cdr.getVariables().getVariableTable().get("sip_hangup_disposition"));
        return lfsCdr;
    }

    private void removeCallInfo(Long callId) {
        CallInfo callInfo = getCallInfo(callId);
        if (Objects.nonNull(callInfo)) {
            callInfo.getChannelMap().forEach((key, value) -> {
                redisService.delCacheMapValue(CacheConstants.CALL_REL_MAP_CACHE_KEY, key);
            });
            redisService.deleteObject(StringUtils.format(CacheConstants.CALL_INFO_CACHE_KEY, callId));
        }
    }

    private CallInfo getCallInfo(Long callId) {
        return redisService.getCacheObject(StringUtils.format(CacheConstants.CALL_INFO_CACHE_KEY, callId));
    }

    private CallInfo getCallInfoByUniqueId(String uniqueId) {
        Long callId = getCallId(uniqueId);
        if (Objects.isNull(callId)) {
            return null;
        }
        return getCallInfo(callId);
    }

    private Long getCallId(String uniqueId) {
        return redisService.getCacheMapValue(CacheConstants.CALL_REL_MAP_CACHE_KEY, uniqueId);
    }
}
