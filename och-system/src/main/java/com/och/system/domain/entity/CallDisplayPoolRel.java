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
 * 号码池号码关联表(CallDisplayPoolRel)表实体类
 *
 * @author danmo
 * @since 2024-08-09 14:55:59
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("call_display_pool_rel")
public class CallDisplayPoolRel extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 423960782716618543L;

    /**
     * 主键
     */

    @Schema(description = "主键")
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 电话池ID
     */
    @Schema(description = "电话池ID")
    @TableField("pool_id")
    private Long poolId;


    /**
     * 号码ID
     */
    @Schema(description = "号码ID")
    @TableField("display_id")
    private Long displayId;


}

