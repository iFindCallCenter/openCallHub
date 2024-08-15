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
 * 号码池管理(CallDisplayPool)表实体类
 *
 * @author danmo
 * @since 2024-08-09 14:55:58
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("call_display_pool")
public class CallDisplayPool extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -34113699790186961L;

    /**
     * 主键
     */

    @Schema(description = "主键")
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 电话池名称
     */
    @Schema(description = "电话池名称")
    @TableField("name")
    private String name;


    /**
     * 类型 1-随机 2-轮询
     */
    @Schema(description = "类型 1-随机 2-轮询")
    @TableField("type")
    private Integer type;

}

