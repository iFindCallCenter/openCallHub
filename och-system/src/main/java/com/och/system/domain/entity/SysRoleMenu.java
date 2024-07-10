package com.och.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.och.common.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;


/**
 * 角色菜单关联表(SysRoleMenu)表实体类
 *
 * @author danmo
 * @since 2024-02-22 11:22:25
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("sys_role_menu")
public class SysRoleMenu extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 641780087656811215L;

    /**
     * 主键ID
     */

    @Schema(description = "主键ID")
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 角色ID
     */
    @Schema(description = "角色ID")
    @TableField("role_id")
    private Long roleId;


    /**
     * 菜单ID
     */
    @Schema(description = "菜单ID")
    @TableField("menu_id")
    private Long menuId;


}

