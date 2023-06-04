package com.jacekg.teamfinder.venueservice.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.stereotype.Service;

import com.jacekg.teamfinder.venueservice.geocoding.GeocodingService;
import com.jacekg.teamfinder.venueservice.model.ActivityType;
import com.jacekg.teamfinder.venueservice.model.IndoorVenue;
import com.jacekg.teamfinder.venueservice.model.OutdoorVenue;
import com.jacekg.teamfinder.venueservice.model.Venue;
import com.jacekg.teamfinder.venueservice.repository.ActivityRepository;
import com.jacekg.teamfinder.venueservice.repository.VenueRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VenueServiceImpl implements VenueService {
	
	private VenueRepository venueRepository;
	private ActivityRepository activityRepository;
	private GeocodingService geocodingService;
	private GeometryFactory geometryFactory;

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
	
	
}
