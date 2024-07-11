package com.och.api.config;

import com.och.api.interceptor.FsXmlCurlInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author danmo
 * @description 拦截器配置
 * @date 2024/4/9 22:58
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private FsXmlCurlInterceptor fsXmlCurlInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(fsXmlCurlInterceptor)
                .addPathPatterns("/fs/cdr", "/fs/curl")
                .excludePathPatterns("");
    }
}
