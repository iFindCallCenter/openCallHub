package com.och.system.domain.query.role;

import com.och.system.domain.query.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2023年07月07日 17:36
 */
@Schema
@Data
public class SysRoleQuery extends BaseQuery {
    /**
     * 角色ID
     */
    @Schema(description = "角色ID")
    private List<Long> roleIds;

    @Schema(description = "角色ID")
    private Long roleId;

    @Schema(description = "角色名称")
    private String name;

    @Schema(description = "状态（0正常 1停用）")
    private Integer status;
}
