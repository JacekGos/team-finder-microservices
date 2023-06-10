package com.jacekg.teamfinder.venueservice.repository;

import java.util.Optional;
import java.util.Set;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jacekg.teamfinder.venueservice.model.ActivityType;
import com.jacekg.teamfinder.venueservice.model.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {
	
	public Optional<Venue> findByLocationAndActivitiesIn(Point location, Set<ActivityType> activityTypes);
}
