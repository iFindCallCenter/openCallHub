package com.och.system.service;

import com.och.common.base.IBaseService;
import com.och.system.domain.entity.CorpInfo;
import com.och.system.domain.query.corp.CorpAddQuery;
import com.och.system.domain.query.corp.CorpQuery;

import java.util.List;

/**
 * 企业信息表(CorpInfo)
 *
 * @author danmo
 * @date 2023-07-07 14:37:57
 */
public interface ICorpInfoService extends IBaseService<CorpInfo> {

    void add(CorpAddQuery query);

    void edit(CorpAddQuery query);

    void delete(CorpQuery query);

    List<CorpInfo> getList(CorpQuery query);
    List<CorpInfo> getPageList(CorpQuery query);

    CorpInfo getByCode(String corpCode);
}
