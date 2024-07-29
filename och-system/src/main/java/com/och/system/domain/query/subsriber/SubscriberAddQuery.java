package com.och.system.domain.query.subsriber;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @author danmo
 * @date 2023年09月25日 13:58
 */
@Schema
@Data
public class SubscriberAddQuery {

    @NotEmpty(message = "账号不能为空")
    @Schema(description = "username",requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;


    @Schema(description = "domain")
    private String domain;

    @NotEmpty(message = "密码不能为空")
    @Schema(description = "password",requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @Schema(description = "状态 0-开启 1-关闭")
    private Integer status;
}
