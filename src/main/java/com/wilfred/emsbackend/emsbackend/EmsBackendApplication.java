package com.wilfred.emsbackend.emsbackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employees API", version = "1.0", description = "Employees Information"))
@SecurityScheme(name = "javainuseapi", scheme = "Bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class EmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}}
