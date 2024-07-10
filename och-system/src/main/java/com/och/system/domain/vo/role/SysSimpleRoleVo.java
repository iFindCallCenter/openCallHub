package com.och.system.domain.vo.role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author danmo
 * @date 2024-02-23 14:30
 **/
@Schema
@Data
public class SysSimpleRoleVo {


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
     * 角色状态（0正常 1停用）
     */
    @Schema(description = "角色状态（0正常 1停用）")
    private Integer status;
}
