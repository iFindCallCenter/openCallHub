package com.och.system.domain.query.acl;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


/**
 * @author danmo
 * @date 2023年09月11日 15:01
 */
@Schema
@Data
public class FsAclAddQuery {

    @Schema(description = "ID", hidden = true)
    private Long id;

    /**
     * 网关名称
     */
    @NotEmpty(message = "名称不能为空")
    @Schema(description = "名称",requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;


    /**
     * 类型 allow-允许 deny-拒绝
     */
    @NotEmpty(message = "类型不能为空")
    @Schema(description = "类型 allow-允许 deny-拒绝",requiredMode = Schema.RequiredMode.REQUIRED)
    private String defaultType;
}
