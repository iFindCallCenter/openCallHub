package com.och.system.domain.query.acl;

import com.och.system.domain.query.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2023年09月11日 15:01
 */
@Schema
@Data
public class FsAclQuery extends BaseQuery {

    @Schema(description = "ID")
    private Long id;

    /**
     * 网关名称
     */
    @Schema(description = "网关名称")
    private String name;


    /**
     * 类型 allow-允许 deny-拒绝
     */
    @Schema(description = "类型 allow-允许 deny-拒绝")
    private String defaultType;


    @Schema(description = "ids")
    private List<Long> ids;
}
