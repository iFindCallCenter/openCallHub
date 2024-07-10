package com.och.system.domain.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author danmo
 * @date 2024年07月10日 22:58
 */
@Schema
@Data
public class BaseQuery {

    @Schema(description = "页码", hidden = true)
    private Integer pageIndex = 1;

    @Schema(description = "条数", hidden = true)
    private Integer pageSize = 10;

    @Schema(description = "排序字段", hidden = true)
    private String sortField;

    @Schema(description = "排序方式 asc、desc", hidden = true)
    private String sort;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Schema(description = "开始时间", example = "yyyy-MM-dd")
    private Date beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Schema(description = "结束时间", example = "yyyy-MM-dd")
    private Date endTime;
}
