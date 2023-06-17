package com.jacekg.teamfinder.eventcoreservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacekg.teamfinder.eventcoreservice.model.Event;

@Service
public class EventCoreServiceImpl implements EventCoreService {

	@Override
	public List<Event> getAllEvents() {
		
		List<Event> events = new ArrayList<>();
		events.add(new Event(1, "Event 1"));
		events.add(new Event(2, "Event 2"));
		
		return events;
	}
}
