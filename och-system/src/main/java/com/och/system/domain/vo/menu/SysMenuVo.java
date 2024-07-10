package com.och.system.domain.vo.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author danmo
 * @date 2024-02-23 11:02
 **/
@Schema
@Data
public class SysMenuVo {

    /**
     * 菜单ID
     */

    @Schema(description = "菜单ID")
    private Long menuId;


    /**
     * 菜单名称
     */
    @Schema(description = "菜单名称")
    private String menuName;


    /**
     * 父菜单ID
     */
    @Schema(description = "父菜单ID")
    private Long parentId;


    /**
     * 显示顺序
     */
    @Schema(description = "显示顺序")
    private Integer orderNum;


    /**
     * 路由地址
     */
    @Schema(description = "路由地址")
    private String path;


    /**
     * 组件路径
     */
    @Schema(description = "组件路径")
    private String component;


    /**
     * 是否为外链（0是 1否）
     */
    @Schema(description = "是否为外链（0是 1否）")
    private Integer isFrame;


    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @Schema(description = "菜单类型（M目录 C菜单 F按钮）")
    private String menuType;


    /**
     * 菜单状态（0显示 1隐藏）
     */
    @Schema(description = "菜单状态（0显示 1隐藏）")
    private Integer visible;


    /**
     * 菜单状态（0正常 1停用）
     */
    @Schema(description = "菜单状态（0正常 1停用）")
    private Integer status;


    /**
     * 权限标识
     */
    @Schema(description = "权限标识")
    private String perms;


    /**
     * 菜单图标
     */
    @Schema(description = "菜单图标")
    private String icon;


    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;
}
