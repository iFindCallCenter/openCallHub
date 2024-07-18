package com.och.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.och.common.base.IBaseService;
import com.och.system.domain.entity.SysCategory;
import com.och.system.domain.query.category.SysCategoryAddQuery;
import com.och.system.domain.query.category.SysCategoryQuery;

import java.util.List;

/**
 * 分类配置表(LfsCategory)表服务接口
 *
 * @author danmo
 * @since 2023-10-31 11:06:55
 */
public interface ISysCategoryService extends IBaseService<SysCategory> {

    void add(SysCategoryAddQuery query);

    void edit(SysCategoryAddQuery query);

    void delete(SysCategoryQuery query);

    SysCategory getDetail(Long id);

    List<Tree<Long>> treeList(SysCategoryQuery query);
}

