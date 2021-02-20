package com.example.m7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example*")
public class M7Application {

	public static void main(String[] args) {
		SpringApplication.run(M7Application.class, args);
	}

}
