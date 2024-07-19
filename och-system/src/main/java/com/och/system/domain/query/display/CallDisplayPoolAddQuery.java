package com.och.system.domain.query.display;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2023-10-23 11:20
 **/
@Schema
@Data
public class CallDisplayPoolAddQuery {

    /**
     * 主键
     */

    @Schema(description = "主键", hidden = true)
    private Long id;


    /**
     * 号码池名称
     */
    @Schema(description = "号码池名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    /**
     * 类型 1-随机 2-轮询
     */
    @Schema(description = "类型 1-随机 2-轮询", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer type;

    /**
     * 号码ID列表
     */
    @Schema(description = "号码ID列表")
    private List<Long> phoneList;
}
