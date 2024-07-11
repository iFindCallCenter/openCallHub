package com.och.esl.config;

import com.och.esl.client.FsClient;
import com.och.esl.propeties.FsClientProperties;
import com.och.system.service.IFsConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author danmo
 * @date 2023年06月28日 18:36
 */
@Slf4j
@Configuration
public class FsClientConfig {

    /**
     * 初始话ESL连接
     *
     * @return
     */
    @Scope("singleton")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public FsClient fsClient(IFsConfigService iFsConfigService, FsClientProperties clientProperties) {
        return new FsClient(iFsConfigService,clientProperties);
    }

}
