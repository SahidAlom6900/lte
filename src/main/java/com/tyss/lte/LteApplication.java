package com.tyss.lte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class LteApplication {

	public static void main(String[] args) {
		SpringApplication.run(LteApplication.class, args);
	}

//	@Bean
//	public ObjectMapper getMapper() {
//		return new ObjectMapper();
//	}
}
