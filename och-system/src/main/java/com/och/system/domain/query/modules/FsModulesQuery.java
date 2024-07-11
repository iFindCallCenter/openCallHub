package com.och.system.domain.query.modules;

import com.och.system.domain.query.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2023年09月15日 15:48
 */
@Schema
@Data
public class FsModulesQuery extends BaseQuery {

    /**
     * 主键ID
     */
    @Schema(description = "主键ID")
    private Long id;

    /**
     * 主键ID
     */
    @Schema(description = "主键ID")
    private List<Long> ids;


    /**
     * FS主机名
     */
    @Schema(description = "FS主机名")
    private String fsName;


    /**
     * 模块名称
     */
    @Schema(description = "模块名称")
    private String name;


    /**
     * 类型 xml格式,json格式
     */
    @Schema(description = "类型 xml格式,json格式")
    private String type;


    /**
     * 内容
     */
    @Schema(description = "内容")
    private String content;


    /**
     * 描述
     */
    @Schema(description = "描述")
    private String describe;
}
