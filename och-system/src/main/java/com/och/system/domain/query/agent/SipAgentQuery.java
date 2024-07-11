package com.och.system.domain.query.agent;

import com.och.system.domain.query.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2023年09月23日 11:03
 */
@Schema
@Data
public class SipAgentQuery extends BaseQuery {

    @Schema(description = "主键ID")
    private Long id;

    @Schema(description = "主键ID")
    private List<Long> ids;

    @Schema(description = "坐席名称")
    private String name;

    @Schema(description = "员工ID")
    private Long userId;

    @Schema(description = "员工名称")
    private String userName;

    @Schema(description = "坐席账号")
    private String agentNumber;

    @Schema(description = "状态 0-未开通 1-开通")
    private Integer status;

    @Schema(description = "在线状态 0-空闲  1-忙碌 2-通话中 3-离线")
    private Integer onlineStatus;
}
