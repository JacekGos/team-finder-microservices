package com.jacekg.teamfinder.venueservice.utils.converter;

import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.Mapping;
import org.springframework.stereotype.Component;

import com.jacekg.teamfinder.venueservice.dto.VenueResponse;
import com.jacekg.teamfinder.venueservice.model.Venue;


@Component
public class ModelMapperConverter implements ModelConverter {
	
	private ModelMapper modelMapper;
	
	public ModelMapperConverter(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	@PostConstruct
	public void init() {
		
	    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		PropertyMap<Venue, VenueResponse> eventPropertyMap = new PropertyMap<Venue, VenueResponse>() {
			@Override
			protected void configure() {
				map().setEventDates(source.getDates());
				map().setActivities(source.getActivitiesNames());
				map().setLat(source.getLat());
				map().setLng(source.getLng());
			}
		};
		
		modelMapper.addMappings(eventPropertyMap);
		
		TypeMap<Venue, VenueResponse> tm = modelMapper.getTypeMap(Venue.class, VenueResponse.class);
	    List<Mapping> list = tm.getMappings();
	    for (Mapping m : list) {
	        System.out.println("mapping: " + m);
	    }
	}
	
	public VenueResponse convertToResponse(Venue venue) {
		
		VenueResponse response = modelMapper.map(venue, VenueResponse.class);
		return response;
	}
}
