package com.jacekg.teamfinder.eventservice.event.controller;

import java.util.List;
import java.util.stream.Collectors;


import static org.springframework.http.ResponseEntity.status;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacekg.teamfinder.eventservice.event.service.EventService;
import com.jacekg.teamfinder.eventservice.utils.ModelConverter;


@RestController
@RequestMapping("/v1/")
public class EventRestController {
	
	private EventService eventService;
	private ModelConverter modelConverter;
		
	
	public EventRestController(EventService eventService, ModelConverter modelConverter) {
		this.eventService = eventService;
		this.modelConverter = modelConverter;
	}

	@GetMapping("/events")
	public ResponseEntity<List<EventResponse>> getAllEvents() {
		return status(HttpStatus.SC_OK).body(eventService.getAllEvents().stream().map(event -> modelConverter.convertToResponse(event)).collect(Collectors.toList()));
	}
}
