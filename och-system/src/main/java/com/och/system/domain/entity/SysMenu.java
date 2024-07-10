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
 * 菜单权限表(SysMenu)表实体类
 *
 * @author danmo
 * @since 2024-02-22 11:22:25
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("sys_menu")
public class SysMenu extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -50303797704840757L;

    /**
     * 菜单ID
     */

    @Schema(description = "菜单ID")
    @TableId(type = IdType.AUTO)
    private Long menuId;


    /**
     * 菜单名称
     */
    @Schema(description = "菜单名称")
    @TableField("menu_name")
    private String menuName;


    /**
     * 父菜单ID
     */
    @Schema(description = "父菜单ID")
    @TableField("parent_id")
    private Long parentId;


    /**
     * 显示顺序
     */
    @Schema(description = "显示顺序")
    @TableField("order_num")
    private Integer orderNum;


    /**
     * 路由地址
     */
    @Schema(description = "路由地址")
    @TableField("path")
    private String path;


    /**
     * 组件路径
     */
    @Schema(description = "组件路径")
    @TableField("component")
    private String component;


    /**
     * 是否为外链（0是 1否）
     */
    @Schema(description = "是否为外链（0是 1否）")
    @TableField("is_frame")
    private Integer isFrame;


    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @Schema(description = "菜单类型（M目录 C菜单 F按钮）")
    @TableField("menu_type")
    private String menuType;


    /**
     * 菜单状态（0显示 1隐藏）
     */
    @Schema(description = "菜单状态（0显示 1隐藏）")
    @TableField("visible")
    private Integer visible;


    /**
     * 菜单状态（0正常 1停用）
     */
    @Schema(description = "菜单状态（0正常 1停用）")
    @TableField("status")
    private Integer status;


    /**
     * 权限标识
     */
    @Schema(description = "权限标识")
    @TableField("perms")
    private String perms;


    /**
     * 菜单图标
     */
    @Schema(description = "菜单图标")
    @TableField("icon")
    private String icon;


    /**
     * 备注
     */
    @Schema(description = "备注")
    @TableField("remark")
    private String remark;


}

