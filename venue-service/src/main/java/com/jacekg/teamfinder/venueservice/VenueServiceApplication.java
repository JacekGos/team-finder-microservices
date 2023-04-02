package com.jacekg.teamfinder.venueservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VenueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VenueServiceApplication.class, args);
	}

}
