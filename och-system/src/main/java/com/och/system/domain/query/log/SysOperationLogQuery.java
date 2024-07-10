package com.och.system.domain.query.log;

import com.och.system.domain.query.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author danmo
 * @date 2024-03-13 14:05
 **/
@EqualsAndHashCode(callSuper = true)
@Schema
@Data
public class SysOperationLogQuery extends BaseQuery {

    @Schema(description = "id")
    private List<Long> ids;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "操作地址")
    private String path;

    @Schema(description = "操作人员")
    private String name;
    @Schema(description = "操作状态（0正常 1异常）")
    private Integer status;
    @Schema(description = "操作类型（0=其它,1=新增,2=修改,3=删除,4=查询,5=导出,6=导入 7-登录 8-登出）")
    private Integer type;

}
