package com.och.system.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.och.common.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 企业信息表(CorpInfo)
 *
 * @author danmo
 * @date 2023-07-07 14:37:57
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("corp_info")
public class CorpInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L; //1

    /**
     * 主键ID
     */
    @Schema(description = "主键ID")
    @TableId(type = IdType.AUTO)
    private Integer id;


    /**
     * 企业名称
     */
    @Schema(description = "企业名称")
    @TableField("corp_name")
    private String corpName;


    /**
     * 企业编码
     */
    @Schema(description = "企业编码")
    @TableField("corp_code")
    private String corpCode;

    /**
     * 验证秘钥
     */
    @Schema(description = "验证秘钥")
    @TableField("secret_key")
    private String secretKey;


    /**
     * 企业状态 1-启用 2-禁用
     */
    @Schema(description = "企业状态 1-启用 2-禁用")
    @TableField("status")
    private Integer status;


    /**
     * 坐席数量
     */
    @Schema(description = "坐席数量")
    @TableField("seat_num")
    private Integer seatNum;


    /**
     * IVR并发数量
     */
    @Schema(description = "IVR并发数量")
    @TableField("ivr_num")
    private Integer ivrNum;


    /**
     * 录音保留天数
     */
    @Schema(description = "录音保留天数")
    @TableField("record_num")
    private Integer recordNum;


    /**
     * 账户余额
     */
    @Schema(description = "账户余额")
    @TableField("balance")
    private String balance;


    /**
     * 企业负责人
     */
    @Schema(description = "企业负责人")
    @TableField("corp_manage")
    private String corpManage;


    /**
     * 企业负责人手机号
     */
    @Schema(description = "企业负责人手机号")
    @TableField("corp_manage_phone")
    private String corpManagePhone;


    /**
     * 备注
     */
    @Schema(description = "备注")
    @TableField("remark")
    private String remark;


    /**
     * 回调地址
     */
    @Schema(description = "回调地址")
    @TableField("call_back_path")
    private String callBackPath;


}
