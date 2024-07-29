package com.och.system.domain.query.corp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @author danmo
 * @date 2023年07月12日 14:07
 */
@Schema
@Data
public class CorpAddQuery {

    /**
     * 主键ID
     */
    @Schema(description = "主键ID", hidden = true)
    private Integer corpId;


    /**
     * 企业名称
     */
    @NotEmpty(message = "企业名称不能为空")
    @Schema(description = "企业名称", requiredMode = Schema.RequiredMode.REQUIRED)
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


    /**
     * 坐席数量
     */
    @Schema(description = "坐席数量")
    private Integer seatNum;


    /**
     * IVR并发数量
     */
    @Schema(description = "IVR并发数量")
    private Integer ivrNum;


    /**
     * 录音保留天数
     */
    @Schema(description = "录音保留天数")
    private Integer recordNum;


    /**
     * 账户余额
     */
    @Schema(description = "账户余额")
    private String balance;


    /**
     * 企业负责人
     */
    @Schema(description = "企业负责人")
    private String corpManage;


    /**
     * 企业负责人手机号
     */
    @Schema(description = "企业负责人手机号")
    private String corpManagePhone;


    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;


    /**
     * 回调地址
     */
    @Schema(description = "回调地址")
    private String callBackPath;
}
