package com.och.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.och.common.base.BaseServiceImpl;
import com.och.common.enums.DeleteStatusEnum;
import com.och.system.domain.entity.Dispatcher;
import com.och.system.domain.query.dispatcher.DispatcherAddQuery;
import com.och.system.domain.query.dispatcher.DispatcherQuery;
import com.och.system.mapper.DispatcherMapper;
import com.och.system.service.IDispatcherService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * (Dispatcher)
 *
 * @author danmo
 * @date 2023-08-29 10:49:18
 */
@Service
public class DispatcherServiceImpl extends BaseServiceImpl<DispatcherMapper, Dispatcher> implements IDispatcherService {


    @Override
    public void add(DispatcherAddQuery query) {
        Dispatcher dispatcher = new Dispatcher();
        BeanUtil.copyProperties(query, dispatcher);
        dispatcher.setSetid(query.getGroupId());
        save(dispatcher);
    }

    @Override
    public void edit(DispatcherAddQuery query) {
        Dispatcher dispatcher = new Dispatcher();
        BeanUtil.copyProperties(query, dispatcher);
        dispatcher.setSetid(query.getGroupId());
        dispatcher.setId(query.getId());
        updateById(dispatcher);
    }

    @Override
    public void delete(DispatcherQuery query) {
        List<Integer> ids = new LinkedList<>();
        if (Objects.nonNull(query.getId())) {
            ids.add(query.getId());
        }
        if (CollectionUtil.isNotEmpty(query.getIds())) {
            ids.addAll(query.getIds());
        }
        if (CollectionUtil.isEmpty(ids)) {
            return;
        }
        List<Dispatcher> list = ids.stream().map(id -> {
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.setDelFlag(DeleteStatusEnum.DELETE_YES.getIndex());
            dispatcher.setId(id);
            return dispatcher;
        }).collect(Collectors.toList());
        updateBatchById(list);
    }

    @Override
    public Dispatcher getDetail(Integer id) {
        return getById(id);
    }

    @Override
    public List<Dispatcher> getList(DispatcherQuery query) {
        LambdaQueryWrapper<Dispatcher> wrapper = new LambdaQueryWrapper<>();
        if (CollectionUtil.isNotEmpty(query.getIds())) {
            wrapper.in(Dispatcher::getId, query.getIds());
        }
        if (Objects.nonNull(query.getId())) {
            wrapper.eq(Dispatcher::getId, query.getId());
        }
        if (Objects.nonNull(query.getGroupId())) {
            wrapper.eq(Dispatcher::getSetid, query.getGroupId());
        }
        if (Objects.nonNull(query.getStatus())) {
            wrapper.eq(Dispatcher::getStatus, query.getStatus());
        }
        if (Objects.nonNull(query.getBeginTime())) {
            wrapper.ge(Dispatcher::getCreateTime, DateUtil.formatDate(query.getBeginTime()));
        }
        if (Objects.nonNull(query.getEndTime())) {
            wrapper.le(Dispatcher::getCreateTime, DateUtil.formatDate(DateUtil.offsetDay(query.getEndTime(), 1)));
        }
        wrapper.eq(Dispatcher::getDelFlag, DeleteStatusEnum.DELETE_NO.getIndex());
        return list(wrapper);
    }

    @Override
    public List<Dispatcher> getPageList(DispatcherQuery query) {
        startPage(query.getPageIndex(), query.getPageSize(), query.getSortField(), query.getSort());
        return getList(query);
    }
}
