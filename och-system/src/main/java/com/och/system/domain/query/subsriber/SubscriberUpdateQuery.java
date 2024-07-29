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
public class SubscriberUpdateQuery {

    @Schema(description = "主键ID", hidden = true)
    private Integer id;

    @NotEmpty(message = "密码不能为空")
    @Schema(description = "SIP密码",requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
}
