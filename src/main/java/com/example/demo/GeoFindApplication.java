package com.example.demo;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class GeoFindApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoFindApplication.class, args);
	}

}
