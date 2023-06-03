package com.jacekg.teamfinder.venueservice.utils;

import com.jacekg.teamfinder.venueservice.dto.VenueResponse;
import com.jacekg.teamfinder.venueservice.model.Venue;

public interface ModelConverter {
	
	public VenueResponse convertToResponse(Venue venue);
}
