package com.och.system.domain.vo.user;

import com.och.system.domain.vo.BaseVo;
import com.och.system.domain.vo.role.SysSimpleRoleVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2024-02-23 14:26
 **/
@Schema
@Data
public class SysUserVo extends BaseVo {

    /**
     * 用户ID
     */

    @Schema(description = "用户ID")
    private Long userId;

    /**
     * 用户账号
     */
    @Schema(description = "用户账号")
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
     * 状态 1-启用 2-禁用
     */
    @Schema(description = "状态 1-启用 2-禁用")
    private Integer status;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    @Schema(description = "角色")
    private List<SysSimpleRoleVo> roleInfo;
}
