package com.techreturners.recordshop;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecordShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordShopApplication.class, args);
	}

		@Bean
		public OpenAPI customOpenAPI(@Value("v1") String appVersion) {
			return new OpenAPI()
					.components(new Components().addSecuritySchemes("basicScheme",
							new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
					.info(new Info()
							.title("🧑‍🎤TR Record Shop")
							.version(appVersion)
							.description("Welcome to the TR Record Shop, a super-store for all your music needs! "
									+ "From Abba to Zappa, you want it? WE GOT IT! ")
							.termsOfService("http://swagger.io/terms/")
							.license(new License().name("Apache 2.0").url("http://springdoc.org")));
		}


}
