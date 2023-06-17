package com.jacekg.teamfinder.eventcoreservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.jacekg.teamfinder.eventcoreservice.model.Event;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventCoreServiceImpl implements EventCoreService {
	
	@Override
	public List<Event> getAllEvents() {
		
		List<Event> events = new ArrayList<>();
		Event event1 = new Event(1, "Event 1");
		Event event2 = new Event(2, "Event 2");
		events.add(event1);
		events.add(event2);
		
		return events;
	}
}
