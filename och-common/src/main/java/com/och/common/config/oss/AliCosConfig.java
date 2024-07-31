package com.och.common.config.oss;

import lombok.Data;

/**
 * 阿里云存储配置
 */
@Data
public class AliCosConfig {
    /**
     * 阿里云域名
     */
    private String host;
    /**
     * 桶名称
     */
    private String bucketName;
}
