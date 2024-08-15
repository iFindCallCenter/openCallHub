package com.och.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.och.common.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 呼叫记录表(CallRecord)表实体类
 *
 * @author danmo
 * @since 2024-08-12 15:30:51
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("call_record")
public class CallRecord extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -89660039865218226L;

    @Schema(description = "主键ID")
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 呼叫ID
     */
    @Schema(description = "呼叫ID")
    @TableField("call_id")
    private Long callId;


    /**
     * 坐席id
     */
    @Schema(description = "坐席id")
    @TableField("agent_id")
    private Integer agentId;


    /**
     * 技能组编号
     */
    @Schema(description = "技能组编号")
    @TableField("group_id")
    private Integer groupId;


    /**
     * 主叫号码
     */
    @Schema(description = "主叫号码")
    @TableField("caller")
    private String caller;


    /**
     * 主叫归属省
     */
    @Schema(description = "主叫归属省")
    @TableField("caller_province")
    private String callerProvince;


    /**
     * 主叫归属市
     */
    @Schema(description = "主叫归属市")
    @TableField("caller_city")
    private String callerCity;


    /**
     * 被叫号码
     */
    @Schema(description = "被叫号码")
    @TableField("callee")
    private String callee;


    /**
     * 被叫归属市
     */
    @Schema(description = "被叫归属市")
    @TableField("callee_city")
    private String calleeCity;


    /**
     * 被叫归属省
     */
    @Schema(description = "被叫归属省")
    @TableField("called_province")
    private String calledProvince;


    /**
     * 原主叫
     */
    @Schema(description = "原主叫")
    @TableField("orig_caller")
    private String origCaller;


    /**
     * 原被叫
     */
    @Schema(description = "原被叫")
    @TableField("orig_callee")
    private String origCallee;


    /**
     * 开始时间
     */
    @Schema(description = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("start_time")
    private Date startTime;


    /**
     * 振铃时间
     */
    @Schema(description = "振铃时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("ringing_time")
    private Date ringingTime;


    /**
     * 接听时间
     */
    @Schema(description = "接听时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("answer_time")
    private Date answerTime;


    /**
     * 结束时间
     */
    @Schema(description = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("end_time")
    private Date endTime;


    /**
     * 坐席振铃时间
     */
    @Schema(description = "坐席振铃时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("agent_ringing_time")
    private Date agentRingingTime;


    /**
     * 坐席接听时间
     */
    @Schema(description = "坐席接听时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("agent_answer_time")
    private Date agentAnswerTime;


    /**
     * 坐席挂机时间
     */
    @Schema(description = "坐席挂机时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("agent_end_time")
    private Date agentEndTime;


    /**
     * 持续时长
     */
    @Schema(description = "持续时长")
    @TableField("duration")
    private Integer duration;


    /**
     * 挂机原因
     */
    @Schema(description = "挂机原因")
    @TableField("hangup_cause")
    private String hangupCause;


    /**
     * 呼叫方向：0：呼入；1：呼出
     */
    @Schema(description = "呼叫方向：0：呼入；1：呼出")
    @TableField("direction")
    private Integer direction;


    /**
     * 录音地址
     */
    @Schema(description = "录音地址")
    @TableField("filepath")
    private String filepath;


    /**
     * 进入队列时间
     */
    @Schema(description = "进入队列时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("queue_stime")
    private Date queueStime;


    /**
     * 退出队列时间
     */
    @Schema(description = "退出队列时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("queue_etime")
    private Date queueEtime;


    /**
     * 录音开始时间
     */
    @Schema(description = "录音开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("record_start_time")
    private Date recordStartTime;


    /**
     * 挂机方向，1主叫，2被叫，3系统
     */
    @Schema(description = "挂机方向，1主叫，2被叫，3系统")
    @TableField("hangup_dir")
    private Integer hangupDir;


    /**
     * 呼叫类型 0 呼入，1 呼出
     */
    @Schema(description = "呼叫类型 0 呼入，1 呼出")
    @TableField("type")
    private Integer type;

    /**
     * 转接前坐席
     */
    @Schema(description = "转接前坐席")
    @TableField("transfer_agent")
    private Integer transferAgent;


    /**
     * 用户发起转坐席操作的时间
     */
    @Schema(description = "用户发起转坐席操作的时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("transfer_agent_time")
    private Date transferAgentTime;


}

