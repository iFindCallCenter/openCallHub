package com.och.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.och.common.base.BaseEntity;
import com.och.system.domain.query.route.CallRouteAddQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


/**
 * 号码路由表(CallRoute)表实体类
 *
 * @author danmo
 * @since 2023-10-18 14:21:22
 */
@ToString
@Schema
@Data
@SuppressWarnings("serial")
@TableName("call_route")
public class CallRoute extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -29457543589162951L;

    @Schema(description = "主键ID")
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 主叫号码
     */
    @Schema(description = "主叫号码")
    @TableField("caller_num")
    private String callerNum;


    /**
     * 路由号码
     */
    @Schema(description = "路由号码")
    @TableField("route_num")
    private String routeNum;


    /**
     * 号码匹配最小长度
     */
    @Schema(description = "号码匹配最小长度")
    @TableField("len_min")
    private Integer lenMin;


    /**
     * 号码匹配最大长度
     */
    @Schema(description = "号码匹配最大长度")
    @TableField("len_max")
    private Integer lenMax;


    /**
     * 主叫替换规则
     */
    @Schema(description = "主叫替换规则")
    @TableField("caller_pattern")
    private String callerPattern;


    /**
     * 主叫替换号码
     */
    @Schema(description = "主叫替换号码")
    @TableField("caller_replace_num")
    private String callerReplaceNum;


    /**
     * 被叫替换规则
     */
    @Schema(description = "被叫替换规则")
    @TableField("callee_pattern")
    private String calleePattern;


    /**
     * 被叫替换号码
     */
    @Schema(description = "被叫替换号码")
    @TableField("callee_replace_num")
    private String calleeReplaceNum;


    /**
     * 状态  0-未启用 1-启用
     */
    @Schema(description = "状态  0-未启用 1-启用")
    @TableField("status")
    private Integer status;



    @Schema(hidden = true)
    public void addQuery2Entity(CallRouteAddQuery query) {
        this.id = query.getId();
        this.callerNum = query.getCallerNum();
        this.routeNum = query.getRouteNum();
        this.lenMin = query.getLenMin();
        this.lenMax = query.getLenMax();
        this.callerPattern = query.getCallerPattern();
        this.callerReplaceNum = query.getCallerReplaceNum();
        this.calleePattern = query.getCalleePattern();
        this.calleeReplaceNum = query.getCalleeReplaceNum();
        this.status = query.getStatus();
    }
}

