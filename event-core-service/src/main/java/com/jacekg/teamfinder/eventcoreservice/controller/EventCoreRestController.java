package com.jacekg.teamfinder.eventcoreservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacekg.teamfinder.eventcoreservice.dto.EventResponse;
import com.jacekg.teamfinder.eventcoreservice.service.EventCoreService;
import com.jacekg.teamfinder.eventcoreservice.utils.converter.ModelMapperConverter;

import static org.springframework.http.ResponseEntity.status;


@RestController
@RequestMapping("/event-core/v1/")
public class EventCoreRestController {
	
	private EventCoreService eventCoreService;
	private ModelMapperConverter modelConverter;

	public EventCoreRestController(EventCoreService eventCoreService, ModelMapperConverter modelConverter) {
		this.eventCoreService = eventCoreService;
		this.modelConverter = modelConverter;
	}

	@GetMapping("/events")
	public ResponseEntity<List<EventResponse>> getAllEvents() {
		return status(HttpStatus.OK).body(this.eventCoreService.getAllEvents().stream()
				.map(event -> modelConverter.convertToResponse(event))
				.collect(Collectors.toList()));
	}

}
