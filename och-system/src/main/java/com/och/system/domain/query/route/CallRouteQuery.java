package com.och.system.domain.query.route;

import com.och.system.domain.query.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2023-10-18 14:34
 **/
@Schema
@Data
public class CallRouteQuery extends BaseQuery {

    @Schema(description = "ID")
    private Long id;

    private List<Long> ids;

    @Schema(description = "路由号码")
    private String routeNumber;

    private String callerNum;

    @Schema(description = "网关类型 1-分机注册 2-外部对接 3-注册网关")
    private Integer type;

}
