package com.och.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.och.system.domain.entity.SysMenu;
import com.och.system.domain.query.menu.SysMenuQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表数据库访问层
 *
 * @author danmo
 * @since 2024-02-22 11:22:25
 */
@Repository()
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getList(SysMenuQuery query);

    List<SysMenu> getMenuListByRoleIds(@Param("roleIds") List<Long> roleIds);
}

