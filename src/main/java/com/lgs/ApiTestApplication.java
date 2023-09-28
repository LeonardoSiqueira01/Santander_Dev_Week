package com.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTestApplication {

	public String PORT = System.getenv("PORT");
	
	public static void main(String[] args) {
		SpringApplication.run(ApiTestApplication.class, args);
	}

}
