package com.och.system.domain.query.user;

import com.och.system.domain.query.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2024-02-23 13:56
 **/
@Schema
@Data
public class SysUserQuery extends BaseQuery {

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Long userId;
    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private List<Long> userIds;

    @Schema(description = "用户名称")
    private String userName;

    @Schema(description = "用户昵称")
    private String nickName;

    @Schema(description = "状态（0正常 1停用）")
    private Integer status;

    @Schema(description = "角色ID")
    private List<Long> roleIds;

    @Schema(description = "部门ID")
    private List<Long> deptIds;
}
