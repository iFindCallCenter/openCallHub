package com.och.system.domain.query.modules;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author danmo
 * @date 2023年09月15日 15:48
 */
@Schema
@Data
public class FsModulesAddQuery {

    /**
     * 主键ID
     */
    @Schema(description = "主键ID", hidden = true)
    private Long id;


    /**
     * FS主机名
     */
    @Schema(description = "FS主机名",requiredMode = Schema.RequiredMode.REQUIRED)
    private String fsName;


    /**
     * 模块名称
     */
    @Schema(description = "模块名称",requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;


    /**
     * 类型 xml格式,json格式
     */
    @Schema(description = "类型 xml格式,json格式",requiredMode = Schema.RequiredMode.REQUIRED)
    private String type;


    /**
     * 内容
     */
    @Schema(description = "内容",requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;


    /**
     * 描述
     */
    @Schema(description = "描述")
    private String describe;
}
