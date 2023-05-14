package com.jacekg.teamfinder.eventservice.event.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jacekg.teamfinder.eventservice.event.controller.EventResponse;
import com.jacekg.teamfinder.eventservice.event.model.Event;
import com.jacekg.teamfinder.eventservice.event.model.FootballEvent;
import com.jacekg.teamfinder.eventservice.event.repository.EventRepository;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

	private EventRepository repository;
	
//	private ModelMapper mapper;
	
	@Transactional
	@Override
	public List<Event> getAllEvents() {
		
		Event event = FootballEvent.builder()
				.name("Piłka nożna")
				.date(LocalDateTime.now())
				.price(20)
				.venueId(1)
				.creatorUserId(1)
				.build();
		
		repository.save(event);

		return repository.findAll();
	}

}
