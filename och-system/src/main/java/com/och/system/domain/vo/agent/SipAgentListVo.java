package com.och.system.domain.vo.agent;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2023年09月26日 13:41
 */
@Schema
@Data
public class SipAgentListVo {


    @Schema(description = "主键ID")
    private Long id;


    @Schema(description = "员工ID")
    private Long userId;

    @Schema(description = "员工名称")
    private String userName;


    @Schema(description = "坐席ID")
    private Integer agentId;

    @Schema(description = "坐席号码")
    private Integer agentNumber;


    //@Schema(description = "显号列表")
    //private List<LfsDisplaySimpleVo> displayList;


}
