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
 * 分类配置表(SysCategory)表实体类
 *
 * @author danmo
 * @since 2023-10-31 11:06:38
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("sys_category")
public class SysCategory extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 760781406688741631L;

    /**
     * 主键id
     */

    @Schema(description = "主键id")
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 1-技能
     */
    @Schema(description = "1-技能 ")
    @TableField("type")
    private Integer type;


    /**
     * 分类名称
     */
    @Schema(description = "分类名称")
    @TableField("name")
    private String name;


    /**
     * 父分类的id
     */
    @Schema(description = "父分类的id")
    @TableField("parent_id")
    private Long parentId;


    /**
     * 可删除标识 0 可删除 1 不可删除
     */
    @Schema(description = "可删除标识 0 可删除 1 不可删除")
    @TableField("flag")
    private Integer flag;


}

