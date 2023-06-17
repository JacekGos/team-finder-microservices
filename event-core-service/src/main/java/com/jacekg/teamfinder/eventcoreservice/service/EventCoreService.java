package com.jacekg.teamfinder.eventcoreservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jacekg.teamfinder.eventcoreservice.model.Event;

public interface EventCoreService {
	
	public List<Event> getAllEvents();
}
