package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicPrjApplication {

	public static void main(String[] args) {
		System.out.println("청춘은 봄이요 봄은 프레임워크");
		SpringApplication.run(BasicPrjApplication.class, args);
	}

}
