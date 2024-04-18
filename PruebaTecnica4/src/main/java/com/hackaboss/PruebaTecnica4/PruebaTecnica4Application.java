package com.hackaboss.PruebaTecnica4;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PruebaTecnica4Application {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnica4Application.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("API agencia de viajes")
				.version("0.0.1")
				.description("Aplicación para gestionar reservas de hoteles y vuelos"));
	}

}
