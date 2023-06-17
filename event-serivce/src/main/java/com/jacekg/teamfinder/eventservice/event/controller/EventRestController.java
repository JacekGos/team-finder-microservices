package com.jacekg.teamfinder.eventservice.event.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.status;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacekg.teamfinder.eventservice.dto.EventRequest;
import com.jacekg.teamfinder.eventservice.dto.EventResponse;
import com.jacekg.teamfinder.eventservice.event.service.EventService;
import com.jacekg.teamfinder.eventservice.utils.converter.ModelMapperConverter;


@RestController
@RequestMapping("/event/v1/")
public class EventRestController {
	
	private EventService eventService;
	private ModelMapperConverter modelConverter;
		
	
	public EventRestController(EventService eventService, ModelMapperConverter modelConverter) {
		this.eventService = eventService;
		this.modelConverter = modelConverter;
	}

	@GetMapping("/events")
	public ResponseEntity<List<EventResponse>> getAllEvents() {
		return status(HttpStatus.OK).body(eventService.getAllEvents().stream().map(event -> modelConverter.convertToResponse(event)).collect(Collectors.toList()));
	}
	
	@PostMapping("/events")
	public ResponseEntity<EventResponse> createVenue(@Valid @RequestBody EventRequest eventRequest) throws Exception {
		return status(HttpStatus.OK).body(modelConverter.convertToResponse(eventService.createEvent(eventRequest)));
	}
}
