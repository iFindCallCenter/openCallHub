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

    private List<FsClientServerProperties> servers = new ArrayList<>();
}
