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

//		Set<ActivityType> activityTypes = new HashSet<>();
//		
//		Optional<ActivityType> foundActivity = activityRepository.findByName("FOOTBALL");
//		ActivityType activity = Optional.ofNullable(foundActivity)
//				.get()
//				.orElse(null);
//		
//		activityTypes.add(activity);
//		
//		foundActivity = activityRepository.findByName("VOLLEYBALL");
//		activity = Optional.ofNullable(foundActivity)
//				.get()
//				.orElse(null);
//		
//		activityTypes.add(activity);
//		
//		
//		Venue newEvent = IndoorVenue.builder()
//				.name("Hala sportowa")
//				.price(250)
//				.activities(activityTypes)
//				.build();
//		
//		venueRepository.saveAndFlush(newEvent);
//		newEvent.addEventDate(new Date());
		
		List<Venue> venues = venueRepository.findAll();
		venues.forEach(venue -> System.out.println("found venue: " +  venue.toString()));
		
		return venues;
	}
	
	@Transactional
	@Override
	public Venue createVenue(VenueRequest venueRequest) throws IOException {
		
		Venue venue = venueCreator.createVenue(venueRequest);
		
		Optional<List<ActivityType>> foundActivites 
			= activityRepository.findByNames(venueRequest.getActivities());
		
		List<ActivityType> activites = Optional.ofNullable(foundActivites)
				.get()
				.orElse(null);
		
		System.out.println("Found activities: " + activites);
		
		venue.setActivities(new HashSet<>(activites));
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
	
}
