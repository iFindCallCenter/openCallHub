package com.och.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.och.common.base.BaseServiceImpl;
import com.och.common.exception.CommonException;
import com.och.common.utils.StringUtils;
import com.och.system.domain.entity.Subscriber;
import com.och.system.domain.query.subsriber.SubscriberAddQuery;
import com.och.system.domain.query.subsriber.SubscriberBatchAddQuery;
import com.och.system.domain.query.subsriber.SubscriberQuery;
import com.och.system.domain.query.subsriber.SubscriberUpdateQuery;
import com.och.system.mapper.SubscriberMapper;
import com.och.system.service.ISubscriberService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * (Subscriber)
 *
 * @author danmo
 * @date 2024-07-29 10:49:24
 */
@Service
public class SubscriberServiceImpl extends BaseServiceImpl<SubscriberMapper, Subscriber> implements ISubscriberService {


    @Override
    public void add(SubscriberAddQuery query) {
        Boolean checked = checkUserName(query.getUsername());
        if (checked) {
            throw new CommonException("账号已存在");
        }
        Subscriber subscriber = new Subscriber();
        subscriber.setUsername(query.getUsername());
        subscriber.setPassword(query.getPassword());
        subscriber.setStatus(query.getStatus());
        save(subscriber);
    }

    private Boolean checkUserName(String username) {
        Subscriber subscriber = getByUserName(username);
        return Objects.nonNull(subscriber);
    }

    @Override
    public void batchAdd(SubscriberBatchAddQuery query) {
        int initNum = query.getInitNum();

        String prefix = StringUtils.rightPad("", 4, "0");

        List<Subscriber> subscriberList = new LinkedList<>();
        for (int i = 0; i < query.getNumber(); i++) {
            Subscriber subscriber = new Subscriber();
            subscriber.setUsername(prefix + initNum);
            if (StringUtils.isBlank(query.getPassword())) {
                subscriber.setPassword(RandomUtil.randomStringWithoutStr(8, ""));
            } else {
                subscriber.setPassword(query.getPassword());
            }
            initNum++;
            subscriberList.add(subscriber);
        }
        if (CollectionUtil.isNotEmpty(subscriberList)) {
            List<String> userNameList = subscriberList.stream().map(Subscriber::getUsername).collect(Collectors.toList());
            List<Subscriber> nameList = getByUserNameList(userNameList);
            if (CollectionUtil.isNotEmpty(nameList)) {
                throw new CommonException("账号已存在");
            }
        }
        saveBatch(subscriberList);
    }

    @Override
    public void edit(SubscriberUpdateQuery query) {
        Subscriber subscriber = new Subscriber();
        subscriber.setPassword(query.getPassword());
        update(new LambdaUpdateWrapper<Subscriber>().eq(Subscriber::getId, query.getId()));
    }

    @Override
    public Subscriber getDetail(Integer id) {
        return getById(id);
    }

    @Override
    public void delete(SubscriberQuery query) {
        remove(new LambdaQueryWrapper<Subscriber>().eq(Subscriber::getId, query.getId()));
    }

    @Override
    public List<Subscriber> getList(SubscriberQuery query) {
        return this.baseMapper.getList(query);
    }

    @Override
    public Subscriber getByUserName(String username) {
        return this.baseMapper.getByUserName(username);
    }

    @Override
    public List<Subscriber> getPageList(SubscriberQuery query) {
        startPage(query.getPageIndex(), query.getPageSize());
        return getList(query);
    }

    public List<Subscriber> getByUserNameList(List<String> userNameList) {
        return this.baseMapper.getByUserNameList(userNameList);
    }
}
