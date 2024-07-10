package com.och.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.och.common.base.IBaseService;
import com.och.system.domain.entity.SysMenu;
import com.och.system.domain.query.menu.SysMenuAddQuery;
import com.och.system.domain.query.menu.SysMenuQuery;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表服务接口
 *
 * @author danmo
 * @since 2024-02-22 11:22:25
 */
public interface ISysMenuService extends IBaseService<SysMenu> {

    void add(SysMenuAddQuery query);

    void edit(SysMenuAddQuery query);

    List<SysMenu> getList(SysMenuQuery query);

    void delete(SysMenuQuery query);

    List<Tree<Long>> buildMenuTree(List<SysMenu> list);

    List<SysMenu> getMenuListByRoleIds(List<Long> roleIds);
}

