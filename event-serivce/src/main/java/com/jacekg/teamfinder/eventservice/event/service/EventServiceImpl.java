package com.jacekg.teamfinder.eventservice.event.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jacekg.teamfinder.eventservice.event.model.BasketballEvent;
import com.jacekg.teamfinder.eventservice.event.model.BicycleEvent;
import com.jacekg.teamfinder.eventservice.event.model.Event;
import com.jacekg.teamfinder.eventservice.event.model.FootballEvent;
import com.jacekg.teamfinder.eventservice.event.model.TennisEvent;
import com.jacekg.teamfinder.eventservice.event.model.VolleyballEvent;
import com.jacekg.teamfinder.eventservice.event.repository.EventRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

	private EventRepository repository;

	
	@Transactional
	@Override
	public List<Event> getAllEvents() {
		
//		Event newEvent = new BicycleEvent("Gierka", LocalDateTime.now(), 10, 1, 1);
		
//		Event newEvent = FootballEvent.builder()
//				.name("Testowa gra")
//				.date(LocalDateTime.now())
//				.price(20)
//				.venueId(2)
//				.creatorUserId(2)
//				.build();
//		
//		repository.save(newEvent);
//		newEvent.addUserId(1);
		
		
		List<Event> events = repository.findAll();
		events.forEach(event -> System.out.println("event: " +  event.toString()));
		
		return events;
	}

}
