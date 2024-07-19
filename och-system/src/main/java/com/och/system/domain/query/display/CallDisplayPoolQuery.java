package com.och.system.domain.query.display;

import com.och.system.domain.query.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2023-10-23 11:20
 **/
@Schema
@Data
public class CallDisplayPoolQuery extends BaseQuery {

    /**
     * 主键
     */

    @Schema(description = "主键")
    private Long id;

    private List<Long> ids;

    /**
     *  号码池名称
     */
    @Schema(description = "号码池名称")
    private String name;

    /**
     *  类型 1-随机 2-轮询
     */
    @Schema(description = "类型 1-随机 2-轮询")
    private Integer type;
}
