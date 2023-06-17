package com.jacekg.teamfinder.eventcoreservice.utils.converter;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.jacekg.teamfinder.eventcoreservice.dto.EventResponse;
import com.jacekg.teamfinder.eventcoreservice.model.Event;


@Component
public class ModelMapperConverter implements ModelConverter {
	
	private ModelMapper modelMapper;
	
	public ModelMapperConverter(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	@PostConstruct
	public void init() {
		
	    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Override
	public EventResponse convertToResponse(Event event) {
		
		EventResponse response = modelMapper.map(event, EventResponse.class);
		return response;
	}
}
