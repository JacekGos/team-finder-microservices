package com.jacekg.teamfinder.eventservice.utils.converter;

import com.jacekg.teamfinder.eventservice.dto.EventResponse;
import com.jacekg.teamfinder.eventservice.event.model.Event;

public interface ModelConverter {
	
	public EventResponse convertToResponse(Event event);

}
