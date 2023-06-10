package com.jacekg.teamfinder.venueservice.config;

import org.locationtech.jts.geom.GeometryFactory;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jacekg.teamfinder.venueservice.utils.venuefactory.VenueBaseCreator;
import com.jacekg.teamfinder.venueservice.utils.venuefactory.VenueCreator;

@Configuration
public class VenueServiceBaseConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public GeometryFactory geometryFactory() {
		return new GeometryFactory();
	}
	
	@Bean
	public VenueCreator venueBaseCreator() {
		return new VenueCreator();
	}
}
