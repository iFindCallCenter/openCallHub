package com.och.system.service;


import com.och.common.base.IBaseService;
import com.och.system.domain.entity.Dispatcher;
import com.och.system.domain.query.dispatcher.DispatcherAddQuery;
import com.och.system.domain.query.dispatcher.DispatcherQuery;

import java.util.List;

/**
 * (Dispatcher)
 *
 * @author danmo
 * @date 2024-07-29 10:49:18
 */
public interface IDispatcherService extends IBaseService<Dispatcher> {

    void add(DispatcherAddQuery query);

    void edit(DispatcherAddQuery query);

    void delete(DispatcherQuery query);

    Dispatcher getDetail(Integer id);

    List<Dispatcher> getList(DispatcherQuery query);
    List<Dispatcher> getPageList(DispatcherQuery query);


}
