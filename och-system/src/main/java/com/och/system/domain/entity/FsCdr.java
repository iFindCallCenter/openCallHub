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
 * cdr话单表(FsCdr)表实体类
 *
 * @author danmo
 * @since 2023-10-26 10:47:11
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("fs_cdr")
public class FsCdr extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -81384805944763542L;

    /**
     * 通话唯一ID
     */

    @Schema(description = "通话唯一ID")
    @TableId(type = IdType.INPUT)
    private Long callId;

    @Schema(description = "通话ID")
    @TableField("uuid")
    private String uuid;

    /**
     * 呼叫方向 outbound-呼出 inbound-呼入
     */
    @Schema(description = "呼叫方向 outbound-呼出 inbound-呼入")
    @TableField("direction")
    private String direction;


    /**
     * 本地呼叫地址
     */
    @Schema(description = "本地呼叫地址")
    @TableField("sip_local_network_addr")
    private String sipLocalNetworkAddr;


    /**
     * 呼叫IP
     */
    @Schema(description = "呼叫IP")
    @TableField("sip_network_ip")
    private String sipNetworkIp;


    /**
     * 主叫号码
     */
    @Schema(description = "主叫号码")
    @TableField("caller_id_number")
    private String callerIdNumber;


    /**
     * 主叫显号
     */
    @Schema(description = "主叫显号")
    @TableField("caller_display")
    private String callerDisplay;


    /**
     * 被叫号码
     */
    @Schema(description = "被叫号码")
    @TableField("destination_number")
    private String destinationNumber;


    /**
     * 被叫显号
     */
    @Schema(description = "被叫显号")
    @TableField("destination_display")
    private String destinationDisplay;


    /**
     * 开始时间
     */
    @Schema(description = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("start_stamp")
    private Date startStamp;


    /**
     * 应答时间
     */
    @Schema(description = "应答时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("answer_stamp")
    private Date answerStamp;


    /**
     * 结束时间
     */
    @Schema(description = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("end_stamp")
    private Date endStamp;


    /**
     * 桥接时间
     */
    @Schema(description = "桥接时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("bridge_stamp")
    private Date bridgeStamp;


    /**
     * 振铃时间
     */
    @Schema(description = "振铃时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("progress_stamp")
    private Date progressStamp;


    /**
     * 呼叫时长
     */
    @Schema(description = "呼叫时长")
    @TableField("duration")
    private Integer duration;


    /**
     * 应答时长
     */
    @Schema(description = "应答时长")
    @TableField("answer_sec")
    private Integer answerSec;


    /**
     * 计费时长
     */
    @Schema(description = "计费时长")
    @TableField("bill_sec")
    private Integer billSec;


    /**
     * 挂断原因
     */
    @Schema(description = "挂断原因")
    @TableField("hangup_cause")
    private String hangupCause;


    /**
     * 录音开始时间
     */
    @Schema(description = "录音开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("record_start_time")
    private Date recordStartTime;


    /**
     * 录音结束时间
     */
    @Schema(description = "录音结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("record_end_time")
    private Date recordEndTime;


    /**
     * 录音时长
     */
    @Schema(description = "录音时长")
    @TableField("record_sec")
    private Integer recordSec;


    /**
     * 录音地址
     */
    @Schema(description = "录音地址")
    @TableField("record")
    private String record;


    /**
     * 读编码类型
     */
    @Schema(description = "读编码类型")
    @TableField("read_codec")
    private String readCodec;


    /**
     * 写编码类型
     */
    @Schema(description = "写编码类型")
    @TableField("write_codec")
    private String writeCodec;


    /**
     * 挂断意向
     */
    @Schema(description = "挂断意向")
    @TableField("sip_hangup_disposition")
    private String sipHangupDisposition;


    @TableField(exist = false)
    private String payload;

    /**
     * 话单通知地址
     */
    @TableField(exist = false)
    private String cdrNotifyUrl;
}

