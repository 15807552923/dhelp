package com.example.webapp;

import com.cxy.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class WebappApplication {


	public static void main(String[] args) {

		TestService testService = new TestService();
		testService.getMessage();
		SpringApplication.run(WebappApplication.class, args);


	}
}
