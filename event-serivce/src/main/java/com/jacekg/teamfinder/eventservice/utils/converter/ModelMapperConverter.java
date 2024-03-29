package com.jacekg.teamfinder.eventservice.utils.converter;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.jacekg.teamfinder.eventservice.dto.EventResponse;
import com.jacekg.teamfinder.eventservice.event.model.Event;
import com.jacekg.teamfinder.eventservice.event.model.FootballEvent;

@Component
public class ModelMapperConverter implements ModelConverter {
	
	private ModelMapper modelMapper;
	
	public ModelMapperConverter(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	@PostConstruct
	public void init() {
		
	    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		PropertyMap<Event, EventResponse> eventPropertyMap = new PropertyMap<Event, EventResponse>() {
			@Override
			protected void configure() {
				map().setUsersId(source.getUsersId());
			}
		};
		
		modelMapper.addMappings(eventPropertyMap);
		
	}
	
	@Override
	public EventResponse convertToResponse(Event event) {
		
		EventResponse response = modelMapper.map(event, EventResponse.class);
		return response;
	}
}
