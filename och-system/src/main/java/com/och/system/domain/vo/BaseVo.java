package com.och.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.och.system.domain.feature.IUserVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author danmo
 * @date 2024-02-20 18:41:37
 */
@Schema
@Data
public class BaseVo implements IUserVo {

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private Long createBy;

    @Schema(description = "创建者")
    private String createName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 更新者
     */
    @Schema(description = "更新者")
    private Long updateBy;

    @Schema(description = "更新者")
    private String updateName;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "更新时间")
    private Date updateTime;

}
