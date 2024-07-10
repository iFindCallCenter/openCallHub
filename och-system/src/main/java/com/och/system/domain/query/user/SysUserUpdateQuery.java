package com.och.system.domain.query.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2024-02-26 13:31
 **/
@Schema
@Data
public class SysUserUpdateQuery {

    /**
     * 用户ID
     */

    @Schema(description = "用户ID",hidden = true)
    private Long userId;


    /**
     * 用户账号
     */
    @NotEmpty(message = "用户名称不能为空")
    @Schema(description = "用户账号",requiredMode = Schema.RequiredMode.REQUIRED)
    private String userName;

    /**
     * 用户昵称
     */
    @Schema(description = "用户昵称")
    private String nickName;

    /**
     * 用户头像
     */
    @Schema(description = "用户头像")
    private String avatar;


    /**
     * 用户性别
     */
    @Schema(description = "用户性别（0-未知 1-男 2-女）")
    private Integer sex;


    /**
     * 手机号
     */
    @Schema(description = "手机号")
    private String phone;


    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    /**
     * 角色ID
     */
    @Schema(description = "角色ID")
    private List<Long> roleIds;

}
