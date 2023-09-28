package com.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers =   {@Server(url = "/",description = "Default server URL")})
@SpringBootApplication
public class ApiTestApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ApiTestApplication.class, args);
	}

}
