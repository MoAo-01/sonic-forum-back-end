package com.sonichollow.forum;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


@MapperScan("com.sonichollow.forum.mapper")
@SpringBootApplication
public class ForumApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }
    protected SpringApplicationBuilder config(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(ForumApplication.class);
    }
}
