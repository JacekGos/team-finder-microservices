package com.jacekg.teamfinder.eventcoreservice.utils.converter;

import com.jacekg.teamfinder.eventcoreservice.dto.EventResponse;
import com.jacekg.teamfinder.eventcoreservice.model.Event;

public interface ModelConverter {
	
	public EventResponse convertToResponse(Event event);

}
