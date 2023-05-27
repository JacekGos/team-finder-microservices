package com.jacekg.teamfinder.eventservice.event.controller;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import static org.springframework.http.ResponseEntity.status;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacekg.teamfinder.eventservice.event.model.Event;
import com.jacekg.teamfinder.eventservice.event.service.EventService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/")
public class EventRestController {
	
	private EventService eventService;
		
	public EventRestController(EventService eventService) {
		this.eventService = eventService;
	}
	
	@GetMapping("/events")
	public ResponseEntity<List<Event>> getAllEvents() {
		
		return status(HttpStatus.SC_OK).body(eventService.getAllEvents());
	}
}
