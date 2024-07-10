package com.och.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.PageInfo;
import com.och.common.base.BaseServiceImpl;
import com.och.common.enums.DeleteStatusEnum;
import com.och.common.exception.CommonException;
import com.och.system.domain.entity.FsAcl;
import com.och.system.domain.query.acl.FsAclAddQuery;
import com.och.system.domain.query.acl.FsAclNodeAddQuery;
import com.och.system.domain.query.acl.FsAclQuery;
import com.och.system.domain.vo.acl.FsAclVo;
import com.och.system.mapper.FsAclMapper;
import com.och.system.service.IFsAclService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * fs访问控制表(FsAcl)
 *
 * @author danmo
 * @date 2023-09-13 13:53:45
 */
@Service
public class FsAclServiceImpl extends BaseServiceImpl<FsAclMapper, FsAcl> implements IFsAclService {


    @Override
    public void addList(FsAclAddQuery query) {
        FsAcl lfsAcl = new FsAcl();
        lfsAcl.setName(query.getName());
        lfsAcl.setDefaultType(query.getDefaultType());
        save(lfsAcl);
    }

    @Override
    public void addNode(FsAclNodeAddQuery query) {
        if (Objects.isNull(query.getListId())) {
            throw new CommonException("规则表ID不能为空");
        }
        FsAcl lfsAcl = new FsAcl();
        lfsAcl.setListId(query.getListId());
        lfsAcl.setCidr(query.getCidr());
        lfsAcl.setNodeType(query.getNodeType());
        lfsAcl.setDomain(query.getDomain());
        save(lfsAcl);
    }

    @Override
    public void editList(FsAclAddQuery query) {
        FsAcl lfsAcl = getById(query.getId());
        if (Objects.isNull(lfsAcl)) {
            throw new CommonException("无效ID");
        }
        FsAcl updateFsAcl = new FsAcl();
        updateFsAcl.setName(query.getName());
        updateFsAcl.setDefaultType(query.getDefaultType());
        updateFsAcl.setId(query.getId());
        updateById(updateFsAcl);
    }

    @Override
    public void editNode(FsAclNodeAddQuery query) {
        FsAcl lfsAcl = getById(query.getId());
        if (Objects.isNull(lfsAcl)) {
            throw new CommonException("无效ID");
        }
        FsAcl updateFsAcl = new FsAcl();
        updateFsAcl.setId(query.getId());
        updateFsAcl.setListId(query.getListId());
        updateFsAcl.setCidr(query.getCidr());
        updateFsAcl.setNodeType(query.getNodeType());
        updateFsAcl.setDomain(query.getDomain());
        updateById(updateFsAcl);
    }

    @Override
    public FsAcl getDetail(Long id) {
        return getById(id);
    }

    @Override
    public void delete(FsAclQuery query) {
        List<Long> ids = new LinkedList<>();
        if (Objects.nonNull(query.getId())) {
            ids.add(query.getId());
        }
        if (CollectionUtil.isNotEmpty(query.getIds())) {
            ids.addAll(query.getIds());
        }
        if (CollectionUtil.isEmpty(ids)) {
            return;
        }
        List<FsAcl> list = ids.stream().map(id -> {
            FsAcl lfsAcl = new FsAcl();
            lfsAcl.setId(id);
            lfsAcl.setDelFlag(DeleteStatusEnum.DELETE_YES.getIndex());
            return lfsAcl;
        }).collect(Collectors.toList());
        updateBatchById(list);
    }

    @Override
    public PageInfo<FsAclVo> pageList(FsAclQuery query) {
        startPage(query.getPageIndex(), query.getPageSize(), query.getSortField(), query.getSort());
        List<Long> ids = this.baseMapper.getIdsByQuery(query);
        if (CollectionUtil.isEmpty(ids)) {
            return new PageInfo<>(new LinkedList<>());
        }
        query.setIds(ids);
        List<FsAclVo> list = getList(query);
        PageInfo<Long> pageIdInfo = new PageInfo<>(ids);
        PageInfo<FsAclVo> pageInfo = new PageInfo<>(list);
        pageInfo.setTotal(pageIdInfo.getTotal());
        pageInfo.setPageNum(pageIdInfo.getPageNum());
        pageInfo.setPageSize(pageIdInfo.getPageSize());
        return pageInfo;
    }

    @Override
    public List<FsAclVo> getList(FsAclQuery query) {
        return this.baseMapper.getList(query);
    }

}
