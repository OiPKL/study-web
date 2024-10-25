package com.ssafy.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Spring Boot Board REST API")
	              .description("내가 만든 게시판 REST API")
	              .version("v0.0.1")
	              .license(new License().name("SSAFY").url("http://www.ssafy.com")));
	  }
	
}
