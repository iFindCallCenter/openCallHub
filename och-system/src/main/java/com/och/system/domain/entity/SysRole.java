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
 * 角色信息表(SysRole)表实体类
 *
 * @author danmo
 * @since 2024-02-22 11:22:25
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("sys_role")
public class SysRole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -98283198015308099L;

    /**
     * 角色ID
     */

    @Schema(description = "角色ID")
    @TableId(type = IdType.AUTO)
    private Long roleId;


    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    @TableField("role_name")
    private String roleName;


    /**
     * 角色权限字符串
     */
    @Schema(description = "角色权限字符串")
    @TableField("role_key")
    private String roleKey;


    /**
     * 显示顺序
     */
    @Schema(description = "显示顺序")
    @TableField("role_sort")
    private Integer roleSort;


    /**
     * 数据范围（1：全部数据权限 2:本部门及以下数据权限 3：本部门数据权限 4：本人数据权限）
     */
    @Schema(description = "数据范围（1：全部数据权限 2:本部门及以下数据权限 3：本部门数据权限 4：本人数据权限）")
    @TableField("data_scope")
    private Integer dataScope;


    /**
     * 角色状态（0正常 1停用）
     */
    @Schema(description = "角色状态（0正常 1停用）")
    @TableField("status")
    private Integer status;


    /**
     * 备注
     */
    @Schema(description = "备注")
    @TableField("remark")
    private String remark;


}

