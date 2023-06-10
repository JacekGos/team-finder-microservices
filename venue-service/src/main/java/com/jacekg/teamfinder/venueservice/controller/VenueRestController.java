package com.jacekg.teamfinder.venueservice.controller;

import static org.springframework.http.ResponseEntity.status;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacekg.teamfinder.venueservice.dto.VenueRequest;
import com.jacekg.teamfinder.venueservice.dto.VenueResponse;
import com.jacekg.teamfinder.venueservice.service.VenueService;
import com.jacekg.teamfinder.venueservice.utils.ModelConverter;


@RestController
@RequestMapping("/v1/")
public class VenueRestController {
	
	VenueService venueService;
	ModelConverter modelConverter;

	public VenueRestController(VenueService venueService, ModelConverter modelConverter) {
		this.venueService = venueService;
		this.modelConverter = modelConverter;
	}
	
	@GetMapping("/venues")
	public ResponseEntity<List<VenueResponse>> getAllEvents() {
		return status(HttpStatus.SC_OK).body(venueService.getAllVenues().stream().map(venue -> modelConverter.convertToResponse(venue)).collect(Collectors.toList()));
	}
	
	@PostMapping("/venues")
	public ResponseEntity<VenueResponse> createVenue(@Valid @RequestBody VenueRequest venueRequest) throws IOException {
		return status(HttpStatus.SC_CREATED).body(modelConverter.convertToResponse(venueService.createVenue(venueRequest)));
	}
	
}
