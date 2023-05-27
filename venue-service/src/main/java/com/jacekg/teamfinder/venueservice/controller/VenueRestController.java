package com.jacekg.teamfinder.venueservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jacekg.teamfinder.venueservice.service.VenueService;

import lombok.AllArgsConstructor;

@RestController
public class VenueRestController {
	
	VenueService venueService;

	public VenueRestController(VenueService venueService) {
		this.venueService = venueService;
	}
	
	
}
