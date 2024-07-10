package com.och.system.domain.query.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author danmo
 * @date 2023年07月07日 17:36
 */
@Schema
@Data
public class SysMenuAddQuery {
    /**
     * 菜单ID
     */
    @Schema(description = "菜单ID", hidden = true)
    private Long menuId;


    /**
     * 菜单名称
     */
    @NotEmpty(message = "菜单名称不能为空")
    @Size(min = 0, max = 50, message = "菜单名称长度不能超过50个字符")
    @Schema(description = "菜单名称", requiredMode = Schema.RequiredMode.REQUIRED)
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
    @NotEmpty(message = "菜单类型不能为空")
    @Schema(description = "菜单类型（M目录 C菜单 F按钮）", requiredMode = Schema.RequiredMode.REQUIRED)
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
