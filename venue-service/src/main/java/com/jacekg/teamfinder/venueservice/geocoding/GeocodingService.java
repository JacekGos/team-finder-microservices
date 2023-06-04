package com.jacekg.teamfinder.venueservice.geocoding;

import java.io.IOException;
import com.jacekg.teamfinder.venueservice.geocoding.model.GeocodeObject;


public interface GeocodingService {
				
	public GeocodeObject findLocationByAddress(String address) throws IOException;
}