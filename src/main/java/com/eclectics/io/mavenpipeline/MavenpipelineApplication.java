package com.eclectics.io.mavenpipeline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableCaching
public class MavenpipelineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenpipelineApplication.class, args);
	}

	@Bean
	CommandLineRunner lineRunner(){
		return args -> {
			System.out.println("MAVEN PIPELINE APPLICATION STARTED SUCCESSFULLY ON " + new Date(System.currentTimeMillis()));
		};
	}

}
