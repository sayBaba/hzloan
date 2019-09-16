package com.hz.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.hz.manager.dao")
public class HzManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzManagerApplication.class, args);
    }

}
