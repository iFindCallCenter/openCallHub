package com.och.system.service;


import com.och.common.base.IBaseService;
import com.och.system.domain.entity.SysRoleMenu;

import java.util.List;

/**
 * 角色菜单关联表(SysRoleMenu)表服务接口
 *
 * @author danmo
 * @since 2024-02-22 11:22:25
 */
public interface ISysRoleMenuService extends IBaseService<SysRoleMenu> {

    void updateBatch(Long roleId, List<Long> menuIds);
}

