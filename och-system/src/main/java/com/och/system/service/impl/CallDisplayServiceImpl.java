package com.och.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.och.common.base.BaseServiceImpl;
import com.och.common.enums.DeleteStatusEnum;
import com.och.system.domain.entity.CallDisplay;
import com.och.system.domain.entity.FsAcl;
import com.och.system.domain.query.display.CallDisplayAddQuery;
import com.och.system.domain.query.display.CallDisplayQuery;
import com.och.system.domain.vo.display.CallDisplayVo;
import com.och.system.mapper.CallDisplayMapper;
import com.och.system.service.ICallDisplayService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        CallDisplay callDisplay = new CallDisplay();
        BeanUtils.copyProperties(query, callDisplay);
        save(callDisplay);
    }

    @Override
    public void edit(CallDisplayAddQuery query) {
        CallDisplay callDisplay = new CallDisplay();
        BeanUtils.copyProperties(query, callDisplay);
        updateById(callDisplay);
    }

    @Override
    public CallDisplay getDetail(Long id) {
        return getDetail(id);
    }

    @Override
    public void delete(CallDisplayQuery query) {
        List<Long> ids = new LinkedList<>();
        if (Objects.nonNull(query.getId())) {
            ids.add(query.getId());
        }
        if (CollectionUtil.isNotEmpty(query.getIdList())) {
            ids.addAll(query.getIdList());
        }
        if (CollectionUtil.isEmpty(ids)) {
            return;
        }
        List<CallDisplay> list = ids.stream().map(id -> {
            CallDisplay display = new CallDisplay();
            display.setId(id);
            display.setDelFlag(DeleteStatusEnum.DELETE_YES.getIndex());
            return display;
        }).collect(Collectors.toList());
        updateBatchById(list);
    }

    @Override
    public List<CallDisplay> getList(CallDisplayQuery query) {
        return baseMapper.getList(query);
    }

    @Override
    public void allocate(CallDisplayQuery query) {

    }

}

