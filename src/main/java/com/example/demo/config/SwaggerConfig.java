package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;



@Configuration
//@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Urban Services - SpringBoot React Example")
                                 .description("Urban Services")
                                 .version("1.0"));
    }
	
//	http://localhost:8080/swagger-ui/index.html#/product-package-controller/create
//	http://localhost:8080/v3/api-docs
	
}
