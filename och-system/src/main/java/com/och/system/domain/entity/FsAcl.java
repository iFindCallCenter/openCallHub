package com.och.system.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.och.common.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * fs访问控制表(FsAcl)
 *
 * @author danmo
 * @date 2023-09-13 13:53:45
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("fs_acl")
public class FsAcl extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L; //1

    /**
     * 主键ID
     */
    @Schema(description = "主键ID")
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 网关名称
     */
    @Schema(description = "网关名称")
    @TableField("name")
    private String name;


    /**
     * 类型 allow-允许 deny-拒绝
     */
    @Schema(description = "类型 allow-允许 deny-拒绝")
    @TableField("default_type")
    private String defaultType;


    /**
     * 列表ID
     */
    @Schema(description = "列表ID")
    @TableField("list_id")
    private Long listId;


    /**
     * 规则类型 allow-允许 deny-拒绝
     */
    @Schema(description = "规则类型 allow-允许 deny-拒绝")
    @TableField("node_type")
    private String nodeType;


    /**
     * IP地址
     */
    @Schema(description = "IP地址")
    @TableField("cidr")
    private String cidr;


    /**
     * 域地址
     */
    @Schema(description = "域地址")
    @TableField("domain")
    private String domain;

}
