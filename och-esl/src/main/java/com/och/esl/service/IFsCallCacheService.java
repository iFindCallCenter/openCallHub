package com.och.esl.service;


import com.och.common.domain.CallInfo;
import com.och.system.domain.vo.route.CallRouteVo;

/**
 * @author danmo
 * @date 2023-10-23 16:43
 **/
public interface IFsCallCacheService {

    void saveCallInfo(CallInfo callInfo);

    CallInfo getCallInfo(Long callId);

    CallInfo getCallInfoByUniqueId(String uniqueId);

    void saveCallRel(String uniqueId, Long callId);

    Long getCallId(String uniqueId);

    CallRouteVo getCallRoute(Integer tenantId, String routeNum, Integer type);


    void removeCallInfo(Long callId);
}
