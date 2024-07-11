package com.och.system.domain.query.dialplan;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author danmo
 * @date 2023年09月15日 11:14
 */
@Schema
@Data
public class FsDialplanAddQuery {

    /**
     * 主键ID
     */
    @Schema(description = "主键ID", hidden = true)
    private Long id;


    /**
     * 分组ID
     */
    @Schema(description = "分组ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long groupId;


    /**
     * 计划名称
     */
    @Schema(description = "计划名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    /**
     * 内容类型 public、default
     */
    @Schema(description = "内容类型 public、default", requiredMode = Schema.RequiredMode.REQUIRED)
    private String contextName;


    /**
     * 类型 xml格式,json格式
     */
    @Schema(description = "类型 xml格式,json格式", requiredMode = Schema.RequiredMode.REQUIRED)
    private String type;


    /**
     * 内容
     */
    @Schema(description = "内容", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;


    /**
     * 描述
     */
    @Schema(description = "描述")
    private String describe;

}
