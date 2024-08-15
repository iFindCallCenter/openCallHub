package com.och.system.service;


import com.github.pagehelper.PageInfo;
import com.och.common.base.IBaseService;
import com.och.system.domain.entity.CallDisplayPool;
import com.och.system.domain.query.display.CallDisplayPoolAddQuery;
import com.och.system.domain.query.display.CallDisplayPoolQuery;
import com.och.system.domain.vo.display.CallDisplayPoolVo;

import java.util.List;

/**
 * 号码池管理(CallDisplayPool)表服务接口
 *
 * @author danmo
 * @since 2024-08-09 14:57:16
 */
public interface ICallDisplayPoolService extends IBaseService<CallDisplayPool> {

    void addPool(CallDisplayPoolAddQuery query);

    void editPool(CallDisplayPoolAddQuery query);

    void deletePool(CallDisplayPoolQuery query);

    CallDisplayPoolVo getPoolDetail(Long id);

    PageInfo<CallDisplayPoolVo> pagePoolList(CallDisplayPoolQuery query);

    List<CallDisplayPoolVo> getPoolList(CallDisplayPoolQuery query);
}

