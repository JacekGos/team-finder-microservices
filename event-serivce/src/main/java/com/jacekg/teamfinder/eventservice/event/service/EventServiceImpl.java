package com.jacekg.teamfinder.eventservice.event.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jacekg.teamfinder.eventservice.dto.EventRequest;
import com.jacekg.teamfinder.eventservice.event.model.Event;
import com.jacekg.teamfinder.eventservice.event.model.FootballEvent;
import com.jacekg.teamfinder.eventservice.event.repository.EventRepository;
import com.jacekg.teamfinder.eventservice.utils.eventfactory.EventBaseCreator;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

	private EventRepository eventRepository;
	private EventBaseCreator eventCreator;
	
	@Transactional
	@Override
	public List<Event> getAllEvents() {
		
		List<Event> events = eventRepository.findAll();
		events.forEach(event -> System.out.println("found event: " +  event.toString()));
		
		return events;
	}

	@Transactional
	@Override
	public Event createEvent(EventRequest eventRequest) {
		
		Event event = eventCreator.createVenue(eventRequest);
		eventRepository.save(event);
		event.addUserId(event.getCreatorUserId());
		eventRepository.save(event);
		
		return event;
	}
}
