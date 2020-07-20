package com.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.platform.dao"})
@EntityScan(basePackages = {"com.platform.entity"})
public class platformApplication {

    public static void main(String[] args) {
        SpringApplication.run(platformApplication.class, args);
    }

}
