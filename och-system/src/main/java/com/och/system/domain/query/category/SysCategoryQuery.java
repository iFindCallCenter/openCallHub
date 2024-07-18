package com.och.system.domain.query.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author danmo
 * @date 2023-10-31 11:16
 **/
@Schema(description = "分类入参")
@Data
public class SysCategoryQuery {
    /**
     *  主键id
     */
    @Schema(description = "主键id")
    private Long id;


    /**
     *  1-技能
     */
    @Schema(description = "1-技能 ")
    private Integer type;



    /**
     *  分类名称
     */
    @Schema(description = "分类名称")
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
