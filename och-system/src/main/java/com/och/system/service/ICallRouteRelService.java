package com.och.system.service;

import com.och.common.base.IBaseService;
import com.och.system.domain.entity.CallRouteRel;

import java.util.List;

/**
 * 号码路由网关配置关联表(CallRouteRel)表服务接口
 *
 * @author danmo
 * @since 2023-10-18 14:52:28
 */
public interface ICallRouteRelService extends IBaseService<CallRouteRel> {

    void add(Long callRouteId, List<CallRouteRel> routeRelList);

    void update(Long callRouteId, List<CallRouteRel> routeRelList);

    void delete(List<Long> callRouteIds);
}

