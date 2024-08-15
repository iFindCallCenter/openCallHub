package com.och.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.och.common.base.IBaseService;
import com.och.system.domain.entity.CallDisplayPoolRel;

import java.util.List;

/**
 * 号码池号码关联表(CallDisplayPoolRel)表服务接口
 *
 * @author danmo
 * @since 2024-08-09 14:58:05
 */
public interface ICallDisplayPoolRelService extends IBaseService<CallDisplayPoolRel> {

    void addByPoolId(Long poolId, List<Long> phoneList);

    void editByPoolId(Long poolId, List<Long> phoneList);

    void delByPoolId(Long poolId);
}

