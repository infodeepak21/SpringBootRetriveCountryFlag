package com.hcl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.hcl.app" })
public class ReadJson {

	public static void main(String[] args) {
		SpringApplication.run(ReadJson.class, args);
	}
}
