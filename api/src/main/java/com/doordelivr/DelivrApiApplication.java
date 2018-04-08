package com.doordelivr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.doordelivr")
@EnableCaching
public class DelivrApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelivrApiApplication.class, args);
	}
}
