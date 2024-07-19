package com.och.system.domain.vo.display;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author danmo
 * @date 2023年09月26日 13:44
 */
@Schema
@Data
public class CallDisplayVo {

    @Schema(description = "ID")
    private String id;

    @Schema(description = "显号号码")
    private String phone;
}
