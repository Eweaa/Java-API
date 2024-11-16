package com.example.demo;

import com.example.demo.Apartment.Apartment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication
{
	private static final Logger log = (Logger) LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args)
	{
		SpringApplication.run(DemoApplication.class, args);
		log.info("Application Started Successfully");
	}

	@Bean
	CommandLineRunner Apartment()
	{
		return args -> {
			Apartment apartment = new Apartment(1, 200 , "Somewhere");
		};
	}

}
