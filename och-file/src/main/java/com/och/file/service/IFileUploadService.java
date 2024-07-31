package com.och.file.service;

import com.och.common.domain.file.LfsFileUploadVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author danmo
 * @date 2023-11-01 15:15
 **/
public interface IFileUploadService {

    /**
     *
     * @param file 文件
     * @param type 上传方式 local ali  tx
     * @return
     * @throws IOException
     */
    LfsFileUploadVo fileUpload(MultipartFile file, String type) throws IOException;

    /**
     *
     * @param file
     * @param type
     * @param businessType 文件类型 1-临时 2-voice 3-file 4-video 5-image
     * @return
     * @throws IOException
     */
    LfsFileUploadVo fileUpload(MultipartFile file, String type, Integer businessType) throws IOException;
}
