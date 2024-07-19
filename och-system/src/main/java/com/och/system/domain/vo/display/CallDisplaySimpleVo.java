package com.och.system.domain.vo.display;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author danmo
 * @date 2023年09月26日 13:44
 */
@Schema
@Data
public class CallDisplaySimpleVo {

    @Schema(description = "显号ID")
    private String displayId;

    @Schema(description = "显号号码")
    private String displayNumber;
}
