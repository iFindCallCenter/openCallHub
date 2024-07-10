package com.och.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.och.system.domain.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 角色菜单关联表(SysRoleMenu)表数据库访问层
 *
 * @author danmo
 * @since 2024-02-22 11:22:25
 */
@Repository()
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

}

