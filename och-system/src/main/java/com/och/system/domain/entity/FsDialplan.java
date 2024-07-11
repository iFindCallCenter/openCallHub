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
 * fs拨号计划表(FsDialplan)
 *
 * @author danmo
 * @date 2023-09-15 11:04:20
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("fs_dialplan")
public class FsDialplan extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L; //1

    /**
     * 主键ID
     */
    @Schema(description = "主键ID")
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 分组ID
     */
    @Schema(description = "分组ID")
    @TableField("group_id")
    private Long groupId;


    /**
     * 计划名称
     */
    @Schema(description = "计划名称")
    @TableField("name")
    private String name;

    /**
     * 内容类型 public、default
     */
    @Schema(description = "内容类型 public、default")
    @TableField("context_name")
    private String contextName;

    /**
     * 类型 xml格式,json格式
     */
    @Schema(description = "类型 xml格式,json格式")
    @TableField("type")
    private String type;


    /**
     * 内容
     */
    @Schema(description = "内容")
    @TableField("content")
    private String content;


    /**
     * 描述
     */
    @Schema(description = "描述")
    @TableField("describe")
    private String describe;


}
