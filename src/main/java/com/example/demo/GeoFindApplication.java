package com.example.demo;

import io.mongock.runner.springboot.EnableMongock;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
@OpenAPIDefinition
/**
 * an application to manage shipping
 */
public class GeoFindApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoFindApplication.class, args);
	}

}
