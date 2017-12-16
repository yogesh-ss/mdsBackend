package com.mds.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mds.*")
public class MdsSpringBootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MdsSpringBootApplication.class, args);
		
	}
}
