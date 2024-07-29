package com.och.system.domain.query.corp;

import com.och.system.domain.query.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2023年07月12日 14:07
 */
@Schema
@Data
public class CorpQuery extends BaseQuery {

    /**
     * 主键ID
     */
    @Schema(description = "主键ID", hidden = true)
    private List<Integer> corpIds;


    /**
     * 企业名称
     */
    @NotEmpty(message = "企业名称不能为空")
    private String corpName;


    /**
     * 企业编码
     */
    @Schema(description = "企业编码")
    private String corpCode;


    /**
     * 企业状态 1-启用 2-禁用
     */
    @Schema(description = "企业状态 1-启用 2-禁用")
    private Integer status;
}
