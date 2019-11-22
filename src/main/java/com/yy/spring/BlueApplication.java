package com.yy.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yy.spring.dao")
public class BlueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueApplication.class, args);
	}

}
