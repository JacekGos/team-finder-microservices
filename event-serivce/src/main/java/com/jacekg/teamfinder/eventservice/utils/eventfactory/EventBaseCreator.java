package com.jacekg.teamfinder.eventservice.utils.eventfactory;

import org.springframework.stereotype.Component;

import com.jacekg.teamfinder.eventservice.dto.EventRequest;
import com.jacekg.teamfinder.eventservice.event.model.Event;

@Component
public abstract class EventBaseCreator {
	
	public abstract Event createVenue(EventRequest venue);
}
