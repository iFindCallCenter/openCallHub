package com.och.system.domain.vo.route;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author danmo
 * @date 2023-10-18 15:51
 **/
@Schema
@Data
public class CallRouteRelVo {

    @Schema(description = "排序")
    private Integer orderNum;

    @Schema(description = "网关配置ID")
    private Long gatewayConfigId;

    @Schema(description = "网关配置名称")
    private String gatewayName;

    @Schema(description = "网关配置地址")
    private String gatewayAddress;

    @Schema(description = "网关配置编码")
    private String gatewayCoding;

    @Schema(description = "网关配置类型 1-分机注册 2-外部对接 3-注册网关")
    private Integer gatewayType;
}
