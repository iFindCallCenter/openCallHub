package com.och.system.service;

import com.och.common.base.IBaseService;
import com.och.system.domain.entity.SysRole;
import com.och.system.domain.query.role.SysRoleAddQuery;
import com.och.system.domain.query.role.SysRoleQuery;
import com.och.system.domain.vo.role.SysRoleVo;

import java.util.List;

/**
 * 角色信息表(SysRole)表服务接口
 *
 * @author danmo
 * @since 2024-02-22 11:22:25
 */
public interface ISysRoleService extends IBaseService<SysRole> {

    List<SysRoleVo> getRoleByUserId(Long userId);

    void add(SysRoleAddQuery query);

    void edit(SysRoleAddQuery query);

    SysRoleVo getDetail(SysRoleQuery query);

    void delete(SysRoleQuery query);

    List<SysRoleVo> getList(SysRoleQuery query);

    List<SysRoleVo> getPageList(SysRoleQuery query);

}

