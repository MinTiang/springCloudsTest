package com.xuejiexiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableEurekaClient
@EnableWebMvc
public class BusinessProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessProviderApplication.class, args);
	}
	
}
