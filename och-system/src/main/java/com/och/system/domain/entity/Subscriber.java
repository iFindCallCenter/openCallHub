package com.och.system.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.och.common.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * (Subscriber) 订阅用户（SIP用户）
 *
 * @author danmo
 * @date 2024-07-29 10:49:24
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("subscriber")
public class Subscriber extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L; //1

    @Schema(description = "id")
    @TableId(type = IdType.AUTO)
    private String id;


    @Schema(description = "username")
    @TableField("username")
    private String username;


    @Schema(description = "domain")
    @TableField("domain")
    private String domain;


    @Schema(description = "password")
    @TableField("password")
    @JsonIgnore
    private String password;


    @Schema(description = "ha1")
    @TableField("ha1")
    private String ha1;


    @Schema(description = "ha1b")
    @TableField("ha1b")
    private String ha1b;


    @Schema(description = "vmpin")
    @TableField("vmpin")
    private String vmpin;


    @Schema(description = "状态 0-开启 1-关闭")
    private Integer status;

}
