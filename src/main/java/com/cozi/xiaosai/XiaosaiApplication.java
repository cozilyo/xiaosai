package com.cozi.xiaosai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class XiaosaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaosaiApplication.class, args);
    }

}
