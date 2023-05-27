package com.jacekg.teamfinder.eventservice.event.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jacekg.teamfinder.eventservice.event.model.Event;
import com.jacekg.teamfinder.eventservice.event.repository.EventRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

	private EventRepository repository;

	
	@Transactional
	@Override
	public List<Event> getAllEvents() {
		
		List<Event> events = repository.findAll();
		events.forEach(event -> System.out.println("event: " +  event.toString()));
		
		return events;
	}

}
