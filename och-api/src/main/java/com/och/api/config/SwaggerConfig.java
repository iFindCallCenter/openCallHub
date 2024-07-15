package com.och.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.ForwardedHeaderFilter;

/**
 * @author danmo
 * @date 2024-02-20 14:24
 */
@Configuration
public class SwaggerConfig {

    /**
     * 标题
     */
    @Value("${swagger.title:}")
    private String title;
    /**
     * 描述
     */
    @Value("${swagger.description:}")
    private String description;
    /**
     * 版本
     */
    @Value("${swagger.version:}")
    private String version;

    //创建Docket对象
    @Bean
    public OpenAPI springOpenApi() {
        Info info = new Info()
                .title(title)
                .version(version)
                .description(description);
        return new OpenAPI().externalDocs(new ExternalDocumentation()
                        .description("doc")).addSecurityItem(new SecurityRequirement().addList(HttpHeaders.AUTHORIZATION))
                .components(new Components().addSecuritySchemes(HttpHeaders.AUTHORIZATION, new SecurityScheme()
                        .name(HttpHeaders.AUTHORIZATION).type(SecurityScheme.Type.HTTP).scheme("bearer")));
    }

    @Bean
    public ForwardedHeaderFilter forwardedHeaderFilter() {
        return new ForwardedHeaderFilter();
    }

}
