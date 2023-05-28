package com.jacekg.teamfinder.venueservice.controller;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacekg.teamfinder.venueservice.model.Venue;
import com.jacekg.teamfinder.venueservice.service.VenueService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/")
public class VenueRestController {
	
	VenueService venueService;

	public VenueRestController(VenueService venueService) {
		this.venueService = venueService;
	}
	
	@GetMapping("/venues")
	public ResponseEntity<List<Venue>> getAllEvents() {
		
		return status(HttpStatus.SC_OK).body(venueService.getAllVenues());
	}
}
