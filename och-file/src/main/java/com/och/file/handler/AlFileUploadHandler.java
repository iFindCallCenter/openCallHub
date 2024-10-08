package com.och.file.handler;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.exceptions.ClientException;
import com.och.common.annotation.FileUploadType;
import com.och.common.config.oss.AliCosConfig;
import com.och.common.domain.file.LfsFileUploadVo;
import com.och.common.exception.FileException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 阿里
 * @author danmo
 * @date 2023-11-01 15:16
 **/
@FileUploadType(value = "ali")
@Slf4j
@Service
public class AlFileUploadHandler extends AbstractFileUploadHandler {


    @Override
    public LfsFileUploadVo upload(MultipartFile file, Integer businessType) throws IOException {
        String newPath = getFileTempPath(businessType);
        String oldName = file.getOriginalFilename();
        //获取扩展名，默认是wav
        String suffix = FileUtil.getSuffix(oldName);
        if (!checkFileFormat(suffix)) {
            throw new FileException(String.format("%s文件格式不被允许上传", suffix));
        }
        String uuid = IdUtil.fastSimpleUUID();
        String fileName = uuid + "." + suffix;
        String saveUrl = newPath + fileName;
        AliCosConfig aliCosConfig = lfsSettingConfig.getAliCosConfig();
        try {
            uploadFile(saveUrl, file.getInputStream(), aliCosConfig.getHost(), aliCosConfig.getBucketName());
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }
        LfsFileUploadVo lfsFileUploadVo = new LfsFileUploadVo();
        lfsFileUploadVo.setId(uuid);
        lfsFileUploadVo.setFilePath(aliCosConfig.getHost() + saveUrl);
        return lfsFileUploadVo;
    }


    private Boolean uploadFile(String url, InputStream inputStream, String endpoint, String bucketName) throws ClientException {
        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, url, inputStream);
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
        } catch (OSSException oe) {
            log.error("上传阿里云存储异常 msg:{}, url:{}", oe.getMessage(), url, oe);
            return false;
        }  finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return true;
    }
}
