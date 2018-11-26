package com.pm.globalGO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class GlobalGoApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(GlobalGoApplication.class, args);
	}
}
