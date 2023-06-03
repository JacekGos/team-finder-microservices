package com.jacekg.teamfinder.eventservice.utils;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.jacekg.teamfinder.eventservice.event.controller.EventResponse;
import com.jacekg.teamfinder.eventservice.event.model.Event;
import com.jacekg.teamfinder.eventservice.event.model.FootballEvent;

@Component
public class ModelConverter {
	
	private ModelMapper modelMapper;
	
	public ModelConverter(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	@PostConstruct
	public void init() {
		
		PropertyMap<FootballEvent, EventResponse> eventPropertyMap = new PropertyMap<FootballEvent, EventResponse>() {
			@Override
			protected void configure() {
				map().setUsersId(source.getUsersId());
			}
		};
		
		modelMapper.addMappings(eventPropertyMap);
		
	}
	
	public EventResponse convertToResponse(Event event) {
		
		EventResponse response = modelMapper.map(event, EventResponse.class);
		return response;
	}
}
