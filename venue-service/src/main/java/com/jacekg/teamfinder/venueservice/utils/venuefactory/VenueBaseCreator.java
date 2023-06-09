package com.jacekg.teamfinder.venueservice.utils.venuefactory;

import org.springframework.stereotype.Component;

import com.jacekg.teamfinder.venueservice.dto.VenueRequest;
import com.jacekg.teamfinder.venueservice.model.Venue;

@Component
public abstract class VenueBaseCreator {
	
	public abstract Venue createVenue(VenueRequest venue);
}
