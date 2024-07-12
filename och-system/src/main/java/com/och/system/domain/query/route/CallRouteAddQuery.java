package com.och.system.domain.query.route;

import com.och.system.domain.entity.CallRouteRel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2023-10-18 14:30
 **/
@Schema
@Data
public class CallRouteAddQuery {

    @Schema(description = "主键ID", hidden = true)
    private Long id;

    /**
     * 主叫号码
     */
    @NotEmpty(message = "主叫号码不能为空")
    @Schema(description = "主叫号码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String callerNum;


    /**
     * 路由号码
     */
    @NotEmpty(message = "路由号码不能为空")
    @Schema(description = "路由号码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String routeNum;


    /**
     * 号码匹配最小长度
     */
    @NotNull(message = "号码匹配最小长度不能为空")
    @Size(min = 4, message = "最小长度为4")
    @Schema(description = "号码匹配最小长度", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer lenMin;


    /**
     * 号码匹配最大长度
     */
    @NotNull(message = " 号码匹配最大长度不能为空")
    @Size(max = 32, message = "最大长度为32")
    @Schema(description = "号码匹配最大长度", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer lenMax;


    /**
     * 主叫替换规则
     */
    @Schema(description = "主叫替换规则")
    private String callerPattern;


    /**
     * 主叫替换号码
     */
    @Schema(description = "主叫替换号码")
    private String callerReplaceNum;


    /**
     * 被叫替换规则
     */
    @Schema(description = "被叫替换规则")
    private String calleePattern;


    /**
     * 被叫替换号码
     */
    @Schema(description = "被叫替换号码")
    private String calleeReplaceNum;


    /**
     * 状态  0-未启用 1-启用
     */
    @Schema(description = "状态  0-未启用 1-启用")
    private Integer status;


    @Schema(description = "网关路由", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<CallRouteRel> routeRelList;

}
