package com.jacekg.teamfinder.venueservice.service;

import java.io.IOException;
import java.util.List;

import com.jacekg.teamfinder.venueservice.dto.VenueRequest;
import com.jacekg.teamfinder.venueservice.model.Venue;

public interface VenueService {
	
	public List<Venue> getAllVenues();
	public Venue createVenue(VenueRequest venueRequest) throws IOException, Exception;
}
