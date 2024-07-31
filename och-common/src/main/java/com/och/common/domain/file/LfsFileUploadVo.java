package com.och.common.domain.file;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author danmo
 * @date 2023-11-02 14:09
 **/
@Schema
@Data
public class LfsFileUploadVo {

    @Schema(description = "文件ID")
    private String id;

    @Schema(description = "文件地址")
    private String filePath;
}
