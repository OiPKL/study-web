package com.ssafy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@MapperScan(basePackages = "com.ssafy.model.dao")
@SpringBootApplication
public class SsafyArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsafyArticleApplication.class, args);
	}


}
