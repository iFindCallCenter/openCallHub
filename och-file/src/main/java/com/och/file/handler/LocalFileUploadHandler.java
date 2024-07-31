package com.och.file.handler;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.och.common.annotation.FileUploadType;
import com.och.common.domain.file.LfsFileUploadVo;
import com.och.common.exception.FileException;
import com.och.common.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 本地
 *
 * @author danmo
 * @date 2023-11-01 15:16
 **/
@FileUploadType(value = "local")
@Slf4j
@Service
public class LocalFileUploadHandler extends AbstractFileUploadHandler {



    @Override
    public LfsFileUploadVo upload(MultipartFile multipartFile, Integer businessType) throws IOException {
        String newPath = getFileTempPath(businessType);
        String oldName = multipartFile.getOriginalFilename();
        //获取扩展名，默认是wav
        String suffix = FileUtil.getSuffix(oldName);
        if(!checkFileFormat(suffix)){
            throw new FileException(String.format("%s文件格式不被允许上传",suffix));
        }
        String uuid = IdUtil.fastSimpleUUID();
        String fileName = uuid +  "." + suffix;
        String saveUrl = newPath + fileName;
        // 保存本地，创建目录
        File file = new File(newPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File saveFile = new File(saveUrl);
        // 序列化文件到本地
        saveFile.createNewFile();
        multipartFile.transferTo(saveFile);

        String hostIp = IpUtils.getHostIp();
        LfsFileUploadVo lfsFileUploadVo = new LfsFileUploadVo();
        lfsFileUploadVo.setId(uuid);
        lfsFileUploadVo.setFilePath(hostIp+saveUrl);
        return lfsFileUploadVo;
    }
}
