package com.och.system.domain.vo.file;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author danmo
 * @date 2023-11-02 11:43
 **/
@Schema
@Data
public class VoiceFileVo {

    /**
     * 主键ID
     */

    @Schema(description = "主键ID")
    private Long id;

    /**
     * 文件名称
     */
    @Schema(description = "文件名称")
    private String name;


    /**
     * 类型 1-本地存储 2-腾讯云 3-阿里云 9-语音合成
     */
    @Schema(description = "类型 1-本地存储 2-腾讯云 3-阿里云 9-语音合成")
    private Integer type;


    /**
     * tts方式 1-腾讯 2-阿里 3-讯飞(type=9生效)
     */
    @Schema(description = "tts方式 1-腾讯 2-阿里 3-讯飞(type=9生效)")
    private Integer tts;


    /**
     * 合成文本
     */
    @Schema(description = "合成文本")
    private String speechText;

    /**
     * 文件ID
     */
    @Schema(description = "文件ID")
    private String fileId;
    /**
     * 文件地址
     */
    @Schema(description = "文件地址")
    private String file;

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private Long createBy;

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

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "更新时间")
    private Date updateTime;
}
