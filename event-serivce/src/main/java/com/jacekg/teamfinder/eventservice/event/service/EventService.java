package com.jacekg.teamfinder.eventservice.event.service;

import java.util.List;

import com.jacekg.teamfinder.eventservice.event.controller.EventResponse;
import com.jacekg.teamfinder.eventservice.event.model.Event;

public interface EventService {
	
	public List<Event> getAllEvents();
}
