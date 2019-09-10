package com.hz.loanBiz;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableEurekaClient
@SpringBootApplication
@MapperScan(value = "com.hz.loanBiz.mapper")
public class LocanBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocanBizApplication.class, args);
	}

}
