package com.cxy.config2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Config2ServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(Config2ServerApplication.class, args);

	}
}
