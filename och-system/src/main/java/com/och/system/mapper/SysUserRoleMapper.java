package com.och.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.och.system.domain.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户角色关联表(SysUserRole)表数据库访问层
 *
 * @author danmo
 * @since 2024-02-22 11:22:25
 */
@Repository()
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}

