package com.och.system.domain.vo.role;

import com.och.system.domain.vo.BaseVo;
import com.och.system.domain.vo.menu.SysMenuVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2024-02-22 13:46
 **/
@Schema
@Data
public class SysRoleVo extends BaseVo {

    /**
     * 角色ID
     */
    @Schema(description = "角色ID")
    private Long roleId;


    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    private String roleName;


    /**
     * 角色权限字符串
     */
    @Schema(description = "角色权限字符串")
    private String roleKey;


    /**
     * 显示顺序
     */
    @Schema(description = "显示顺序")
    private Integer roleSort;


    /**
     * 数据范围（1：全部数据权限 2:本部门及以下数据权限 3：本部门数据权限 4：本人数据权限）
     */
    @Schema(description = "数据范围（1：全部数据权限 2:本部门及以下数据权限 3：本部门数据权限 4：本人数据权限）")
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

    @Schema(description = "菜单")
    private List<SysMenuVo> menuList;
}
