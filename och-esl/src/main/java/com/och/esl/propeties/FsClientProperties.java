package com.och.esl.propeties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danmo
 * @date 2023年09月18日 15:05
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "freeswitch.esl")
public class FsClientProperties {

    private int workerGroupThread = Runtime.getRuntime().availableProcessors() * 2;

    private int publicExecutorThread = Runtime.getRuntime().availableProcessors() * 2;

    private int privateExecutorThread = Runtime.getRuntime().availableProcessors() * 2;

    private int callbackExecutorThread = Runtime.getRuntime().availableProcessors() * 2;

    private List<FsClientServerProperties> servers = new ArrayList<>();
}
