package com.jacekg.teamfinder.userservice.utils;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.jacekg.teamfinder.userservice.dto.UserResponse;
import com.jacekg.teamfinder.userservice.model.User;

@Component
public class ModelConverter {
	
	private ModelMapper modelMapper;
	
	public ModelConverter(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	@PostConstruct
	public void init() {
		
	    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		PropertyMap<User, UserResponse> eventPropertyMap = new PropertyMap<User, UserResponse>() {
			@Override
			protected void configure() {
				map().setRoles(source.getRolesNames());
				map().setEventsId(source.getEventsId());
			}
		};
		
		
		
		modelMapper.addMappings(eventPropertyMap);
		
	}
	
	public UserResponse convertToResponse(User user) {
		UserResponse response = modelMapper.map(user, UserResponse.class);
		return response;
	}
}
