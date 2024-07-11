package com.och.system.domain.query.dialplan;

import com.och.system.domain.query.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2023年09月15日 11:14
 */
@Schema
@Data
public class FsDialplanQuery extends BaseQuery {

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
     * 分组ID
     */
    @Schema(description = "分组ID")
    private Long groupId;


    /**
     * 计划名称
     */
    @Schema(description = "计划名称")
    private String name;

    /**
     * 内容类型 public、default
     */
    @Schema(description = "内容类型 public、default")
    private String contextName;


    /**
     * 类型 xml格式,json格式
     */
    @Schema(description = "类型 xml格式,json格式")
    private String type;

    /**
     * 描述
     */
    @Schema(description = "描述")
    private String describe;

}
