package com.jacekg.teamfinder.venueservice.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jacekg.teamfinder.venueservice.model.ActivityType;
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

	@Transactional
	@Override
	public List<Venue> getAllVenues() {

//		Set<ActivityType> activityTypes = new HashSet<>();
//		activityTypes.add(activityRepository.findByName("FOOTBALL"));
//		activityTypes.add(activityRepository.findByName("BASKETBALL"));
//		
//		Venue newEvent = OutdoorVenue.builder()
//				.name("Boisko")
//				.price(200)
//				.activities(activityTypes)
//				.build();
//		
//		venueRepository.save(newEvent);
		
		List<Venue> venues = venueRepository.findAll();
		venues.forEach(venue -> System.out.println("found venue: " +  venue.toString()));
		
		return null;
	}
	
	
}
