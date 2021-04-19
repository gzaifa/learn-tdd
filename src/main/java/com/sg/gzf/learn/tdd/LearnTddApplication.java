package com.sg.gzf.learn.tdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LearnTddApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnTddApplication.class, args);
	}

}
