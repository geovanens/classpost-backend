package com.classpost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ClasspostApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClasspostApplication.class, args);
	}
}
