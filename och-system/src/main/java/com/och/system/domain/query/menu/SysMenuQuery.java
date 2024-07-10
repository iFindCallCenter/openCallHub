package com.och.system.domain.query.menu;

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
public class SysMenuQuery extends BaseQuery {
    /**
     * 菜单ID
     */
    @Schema(description = "菜单ID")
    private List<Long> menuIds;
    /**
     * 菜单ID
     */
    @Schema(description = "菜单ID")
    private Long menuId;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "菜单状态（0正常 1停用）")
    private Integer status;
}
