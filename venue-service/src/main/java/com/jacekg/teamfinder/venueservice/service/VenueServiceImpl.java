package com.jacekg.teamfinder.venueservice.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import com.jacekg.teamfinder.venueservice.dto.VenueRequest;
import com.jacekg.teamfinder.venueservice.dto.VenueResponse;
import com.jacekg.teamfinder.venueservice.geocoding.GeocodingService;
import com.jacekg.teamfinder.venueservice.geocoding.model.GeocodeLocation;
import com.jacekg.teamfinder.venueservice.geocoding.model.GeocodeObject;
import com.jacekg.teamfinder.venueservice.model.ActivityType;
import com.jacekg.teamfinder.venueservice.model.IndoorVenue;
import com.jacekg.teamfinder.venueservice.model.OutdoorVenue;
import com.jacekg.teamfinder.venueservice.model.Venue;
import com.jacekg.teamfinder.venueservice.repository.ActivityRepository;
import com.jacekg.teamfinder.venueservice.repository.VenueRepository;
import com.jacekg.teamfinder.venueservice.utils.venuefactory.VenueBaseCreator;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VenueServiceImpl implements VenueService {
	
	private VenueRepository venueRepository;
	private ActivityRepository activityRepository;
	private GeocodingService geocodingService;
	private GeometryFactory geometryFactory;
	private VenueBaseCreator venueCreator;

	@Transactional
	@Override
	public List<Venue> getAllVenues() {

		List<Venue> venues = venueRepository.findAll();
		venues.forEach(venue -> System.out.println("found venue: " +  venue.toString()));
		
		return venues;
	}
	
	@Transactional
	@Override
	public Venue createVenue(VenueRequest venueRequest) throws IOException {
		
		Venue venue = venueCreator.createVenue(venueRequest);
		venue.setActivities(getActivitiesByNames(venueRequest.getActivities()));
		venue.setLocation(getLocationByAddress(venueRequest.getAddress()));
		
		venueRepository.save(venue);
		
		return venue;
	}
	
	private Point getLocationByAddress(String address) throws IOException {
		
		GeocodeObject geocodeObject = geocodingService.findLocationByAddress(address);
		GeocodeLocation location = geocodeObject.getGeometry().getGeocodeLocation();
		Point coordinates = geometryFactory.createPoint(new Coordinate(location.getLatitude(), location.getLongitude()));
		
		System.out.println("Location found: " + coordinates.toString());
		
		return coordinates;
	}
	
	private Set<ActivityType> getActivitiesByNames(List<String> names) {
		
		System.out.println("Activities names: " + names);
		
		Optional<List<ActivityType>> foundActivites 
			= activityRepository.findByNames(names);
	
		List<ActivityType> activites = Optional.ofNullable(foundActivites)
			.get()
			.orElse(null);
	
		System.out.println("Found activities: " + activites);
		
		return new HashSet<>(activites);
	}
}
