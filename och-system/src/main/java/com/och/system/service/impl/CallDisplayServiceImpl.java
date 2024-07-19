package com.och.system.service.impl;

import com.och.common.base.BaseServiceImpl;
import com.och.system.domain.entity.CallDisplay;
import com.och.system.domain.query.display.CallDisplayAddQuery;
import com.och.system.domain.query.display.CallDisplayQuery;
import com.och.system.domain.vo.display.CallDisplayVo;
import com.och.system.mapper.CallDisplayMapper;
import com.och.system.service.ICallDisplayService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 号码管理(CallDisplay)表服务实现类
 *
 * @author danmo
 * @since 2023-10-23 10:45:58
 */
@Service
public class CallDisplayServiceImpl extends BaseServiceImpl<CallDisplayMapper, CallDisplay> implements ICallDisplayService {

    @Override
    public void add(CallDisplayAddQuery query) {

    }

    @Override
    public void edit(CallDisplayAddQuery query) {

    }

    @Override
    public CallDisplayVo getDetail(Long id) {
        return null;
    }

    @Override
    public void delete(CallDisplayQuery query) {

    }

    @Override
    public List<CallDisplay> getList(CallDisplayQuery query) {
        return null;
    }

    @Override
    public void allocate(CallDisplayQuery query) {

    }

}

