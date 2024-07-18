package com.och.system.domain.query.category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author danmo
 * @date 2023-10-31 11:16
 **/
@Schema(description = "新增分类入参")
@Data
public class SysCategoryAddQuery {
    /**
     *  主键id
     */
    @Schema(description = "主键id",hidden = true)
    private Long id;

    /**
     *  1-技能
     */
    @NotNull(message = "分类类型不能为空")
    @Schema(description = "1-技能 ",requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer type;



    /**
     *  分类名称
     */
    @NotEmpty(message = "分类名称不能为空")
    @Schema(description = "分类名称",requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;



    /**
     *  父分类的id
     */
    @Schema(description = "父分类的id")
    private Long parentId = 0L;



    /**
     *  可删除标识 0 可删除 1 不可删除
     */
    @Schema(description = "可删除标识 0 可删除 1 不可删除")
    private Integer flag;

}
