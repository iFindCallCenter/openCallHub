package com.och.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.och.common.base.BaseServiceImpl;
import com.och.common.enums.DeleteStatusEnum;
import com.och.system.domain.entity.CallRouteRel;
import com.och.system.mapper.CallRouteRelMapper;
import com.och.system.service.ICallRouteRelService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 号码路由网关配置关联表(CallRouteRel)表服务实现类
 *
 * @author danmo
 * @since 2023-10-18 14:52:28
 */
@Service
public class CallRouteRelServiceImpl extends BaseServiceImpl<CallRouteRelMapper, CallRouteRel> implements ICallRouteRelService {

    @Override
    public void add(Long callRouteId, List<CallRouteRel> routeRelList) {
        if (CollectionUtil.isNotEmpty(routeRelList)) {
            routeRelList.forEach(item -> item.setCallRouteId(callRouteId));
            saveBatch(routeRelList);
        }
    }

    @Override
    public void update(Long callRouteId, List<CallRouteRel> routeRelList) {
        delete(Collections.singletonList(callRouteId));
        add(callRouteId, routeRelList);
    }

    @Override
    public void delete(List<Long> callRouteIds) {
        CallRouteRel lfsCallRouteRel = new CallRouteRel();
        lfsCallRouteRel.setDelFlag(DeleteStatusEnum.DELETE_YES.getIndex());
        update(lfsCallRouteRel, new LambdaQueryWrapper<CallRouteRel>().in(CallRouteRel::getCallRouteId, callRouteIds));
    }
}

