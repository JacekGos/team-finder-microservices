package com.jacekg.teamfinder.eventservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jacekg.teamfinder.eventservice.utils.eventfactory.EventCreator;

@Configuration
public class EventServiceBaseConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public EventCreator eventBaseCreator() {
		return new EventCreator();
	}
}
