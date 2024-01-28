package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
//@EnableJpaRepositories("com.example.demo.repository")
@SpringBootApplication
//@EnableDiscoveryClient
public class SpringBReactMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBReactMySqlApplication.class, args);
		System.out.println("Testing...");
	}

}

