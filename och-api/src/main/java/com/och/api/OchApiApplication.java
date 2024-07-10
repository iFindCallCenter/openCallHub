package com.och.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@EnableMethodSecurity
@ComponentScan(basePackages = {"com.och"})
@MapperScan("com.och.**.mapper")
@EnableAsync
@SpringBootApplication
public class OchApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OchApiApplication.class, args);
    }

}
