package com.sonichollow.forum;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@MapperScan("com.sonichollow.forum.mapper")
@SpringBootApplication
public class ForumApplication {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        //可以通过环境变量获取你的mapper路径,这样mapper扫描可以通过配置文件配置了
        scannerConfigurer.setBasePackage("com.sonichollow.*.mapper");
        return scannerConfigurer;
    }
    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }

}
