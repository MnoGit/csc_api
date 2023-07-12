package com.csc.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(
		name ="bearer",
		type = SecuritySchemeType.HTTP,
		scheme = "bearer"
)
@OpenAPIDefinition(
		info = @Info(title = "Sample API", version = "v1"),
		security = @SecurityRequirement(name = "bearer") // require all endpoint
)


public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
