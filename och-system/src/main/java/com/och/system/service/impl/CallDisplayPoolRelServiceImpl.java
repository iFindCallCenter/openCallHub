package com.och.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.och.common.base.BaseServiceImpl;
import com.och.common.enums.DeleteStatusEnum;
import com.och.system.domain.entity.CallDisplayPoolRel;
import com.och.system.mapper.CallDisplayPoolRelMapper;
import com.och.system.service.ICallDisplayPoolRelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 号码池号码关联表(CAllDisplayPoolRel)表服务实现类
 *
 * @author danmo
 * @since 2024-08-09 14:58:05
 */
@Service
public class CallDisplayPoolRelServiceImpl extends BaseServiceImpl<CallDisplayPoolRelMapper, CallDisplayPoolRel> implements ICallDisplayPoolRelService {

    @Override
    public void addByPoolId(Long poolId, List<Long> phoneList) {
        if(CollectionUtil.isEmpty(phoneList)){
            return;
        }
        List<CallDisplayPoolRel> relList = phoneList.stream().map(displayId -> {
            CallDisplayPoolRel rel = new CallDisplayPoolRel();
            rel.setDisplayId(displayId);
            rel.setPoolId(poolId);
            return rel;
        }).collect(Collectors.toList());
        saveBatch(relList);
    }

    @Override
    public void editByPoolId(Long poolId, List<Long> phoneList) {
        if(CollectionUtil.isEmpty(phoneList)){
            return;
        }
        delByPoolId(poolId);
        addByPoolId(poolId,phoneList);
    }

    @Override
    public void delByPoolId(Long poolId) {
        CallDisplayPoolRel rel = new CallDisplayPoolRel();
        rel.setDelFlag(DeleteStatusEnum.DELETE_YES.getIndex());
        update(rel,new LambdaQueryWrapper<CallDisplayPoolRel>().eq(CallDisplayPoolRel::getPoolId,poolId));
    }
}

