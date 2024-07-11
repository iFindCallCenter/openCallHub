package com.och.system.domain.vo.agent;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author danmo
 * @date 2023年09月26日 13:41
 */
@Schema
@Data
public class SipAgentVo {


    @Schema(description = "主键ID")
    private Long id;

    @Schema(description = "坐席名称")
    private String name;

    @Schema(description = "员工ID")
    private Long userId;

    @Schema(description = "员工名称")
    private String userName;

    @Schema(description = "SIP号码")
    private String agentNumber;


    @Schema(description = "状态 0-未开通 1-开通")
    private Integer status;
    /**
     * 状态 0-空闲  1-忙碌 2-通话中 3-离线
     */
    @Schema(description = "在线状态 0-空闲  1-忙碌 2-通话中 3-离线")
    private Integer onlineStatus;
}
