package com.jacekg.teamfinder.eventcoreservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EventCoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventCoreServiceApplication.class, args);
	}

}
