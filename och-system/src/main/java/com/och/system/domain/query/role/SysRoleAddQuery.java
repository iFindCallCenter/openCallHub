package com.och.system.domain.query.role;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2023年07月07日 17:36
 */
@Schema
@Data
public class SysRoleAddQuery {
    /**
     * 角色ID
     */
    @Schema(description = "角色ID")
    private Long roleId;


    /**
     * 角色名称
     */
    @NotEmpty(message = "角色名称不能为空")
    @Schema(description = "角色名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String roleName;


    /**
     * 角色权限字符串
     */
    @Schema(description = "角色权限字符串", requiredMode = Schema.RequiredMode.REQUIRED)
    private String roleKey;


    /**
     * 显示顺序
     */
    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer roleSort;


    /**
     * 数据范围（1：全部数据权限 2:本部门及以下数据权限 3：本部门数据权限 4：本人数据权限）
     */
    @Schema(description = "数据范围（1：全部数据权限 2:本部门及以下数据权限 3：本部门数据权限 4：本人数据权限）", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer dataScope;


    /**
     * 角色状态（0正常 1停用）
     */
    @Schema(description = "角色状态（0正常 1停用）")
    private Integer status;


    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    /**
     * 菜单ID
     */
    @Schema(description = "菜单ID")
    private List<Long> menuIds;

}
