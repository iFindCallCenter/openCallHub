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
 * 坐席管理表(SysAgent)
 *
 * @author danmo
 * @date 2023-09-26 11:08:58
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("sip_agent")
public class SipAgent extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L; //1


    @Schema(description = "主键ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @Schema(description = "坐席名称")
    @TableField("name")
    private String name;

    @Schema(description = "员工ID")
    @TableField("user_id")
    private Long userId;


    @Schema(description = "sip账号")
    @TableField("agent_number")
    private String agentNumber;

    @Schema(description = "状态 0-未开通 1-开通")
    @TableField("status")
    private Integer status;

    /**
     * 状态 0-空闲  1-忙碌 2-通话中 3-离线
     */
    @Schema(description = "在线状态 0-空闲  1-忙碌 2-通话中 3-离线")
    @TableField("online_status")
    private Integer onlineStatus;
}
