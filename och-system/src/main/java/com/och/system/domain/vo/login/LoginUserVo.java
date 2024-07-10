package com.och.system.domain.vo.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * @author danmo
 * @date 2024-02-21 15:22
 **/
@Schema
@Builder
@Data
public class LoginUserVo {

    @Schema(description = "accessToken")
    private String accessToken;

    @Schema(description = "缓存有效期(分钟)")
    private Integer expiresIn;
}
