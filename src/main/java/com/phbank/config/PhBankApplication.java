package com.phbank.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.phbank"})
public class PhBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhBankApplication.class, args);
	}
}
