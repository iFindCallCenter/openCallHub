package com.och.system.domain.vo.display;

import com.och.system.domain.vo.BaseVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author danmo
 * @date 2023年09月26日 13:44
 */
@Schema
@Data
public class CallDisplayPoolVo extends BaseVo {

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "号码池名称")
    private String name;

    @Schema(description = "类型 1-随机 2-轮询")
    private Integer type;

    @Schema(description = "显号号码")
    private List<CallDisplaySimpleVo> phoneList;

}
