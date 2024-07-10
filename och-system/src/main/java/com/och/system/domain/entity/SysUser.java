package com.och.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.och.common.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 用户信息表(User)表实体类
 *
 * @author danmo
 * @since 2024-02-20 18:41:37
 */
@EqualsAndHashCode(callSuper = true)
@Schema
@Data
@SuppressWarnings("serial")
@TableName("sys_user")
public class SysUser extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 709948659840527062L;

    /**
     * 用户ID
     */

    @Schema(description = "用户ID")
    @TableId(type = IdType.AUTO)
    private Long userId;


    /**
     * 用户账号
     */
    @Schema(description = "用户账号")
    @TableField("user_name")
    private String userName;


    /**
     * 用户昵称
     */
    @Schema(description = "用户昵称")
    @TableField("nick_name")
    private String nickName;


    /**
     * 密码
     */
    @Schema(description = "密码")
    @TableField("password")
    private String password;


    /**
     * 用户头像
     */
    @Schema(description = "用户头像")
    @TableField("avatar")
    private String avatar;


    /**
     * 用户性别
     */
    @Schema(description = "用户性别（0-未知 1-男 2-女）")
    @TableField("sex")
    private Integer sex;


    /**
     * 手机号
     */
    @Schema(description = "手机号")
    @TableField("phone")
    private String phone;


    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    @TableField("email")
    private String email;


    /**
     * 状态 1-启用 2-禁用
     */
    @Schema(description = "状态 1-启用 2-禁用")
    @TableField("status")
    private Integer status;


    /**
     * 备注
     */
    @Schema(description = "备注")
    @TableField("remark")
    private String remark;

}

