package com.och.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.och.common.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统操作日志记录(SysOperLog)表实体类
 *
 * @author danmo
 * @since 2024-03-12 19:09:58
 */
@Schema
@Data
@SuppressWarnings("serial")
@TableName("sys_oper_log")
public class SysOperLog extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 346053824437491098L;

    /**
     * 日志主键
     */

    @Schema(description = "日志主键")
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 标题
     */
    @Schema(description = "标题")
    @TableField("title")
    private String title;


    /**
     * 业务类型（0=其它,1=新增,2=修改,3=删除,4=查询,5=导出,6=导入 7-登录 8-登出）
     */
    @Schema(description = "业务类型（0=其它,1=新增,2=修改,3=删除,4=查询,5=导出,6=导入 7-登录 8-登出）")
    @TableField("business_type")
    private Integer businessType;


    /**
     * 方法名称
     */
    @Schema(description = "方法名称")
    @TableField("method")
    private String method;


    /**
     * 请求方式
     */
    @Schema(description = "请求方式")
    @TableField("request_method")
    private String requestMethod;


    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    @Schema(description = "操作类别（0其它 1后台用户 2手机端用户）")
    @TableField("operator_type")
    private Integer operatorType;


    /**
     * 操作人员
     */
    @Schema(description = "操作人员")
    @TableField("oper_name")
    private String operName;


    /**
     * 部门名称
     */
    @Schema(description = "部门名称")
    @TableField("dept_name")
    private String deptName;


    /**
     * 请求URL
     */
    @Schema(description = "请求URL")
    @TableField("oper_url")
    private String operUrl;


    /**
     * 主机地址
     */
    @Schema(description = "主机地址")
    @TableField("oper_ip")
    private String operIp;


    /**
     * 操作地点
     */
    @Schema(description = "操作地点")
    @TableField("oper_location")
    private String operLocation;


    /**
     * 请求参数
     */
    @Schema(description = "请求参数")
    @TableField("oper_param")
    private String operParam;


    /**
     * 返回参数
     */
    @Schema(description = "返回参数")
    @TableField("json_result")
    private String jsonResult;


    /**
     * 操作状态（0正常 1异常）
     */
    @Schema(description = "操作状态（0正常 1异常）")
    @TableField("status")
    private Integer status;


    /**
     * 错误消息
     */
    @Schema(description = "错误消息")
    @TableField("error_msg")
    private String errorMsg;


    /**
     * 操作时间
     */
    @Schema(description = "操作时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("oper_time")
    private Date operTime;


    /**
     * 消耗时间
     */
    @Schema(description = "消耗时间")
    @TableField("cost_time")
    private Long costTime;


}

