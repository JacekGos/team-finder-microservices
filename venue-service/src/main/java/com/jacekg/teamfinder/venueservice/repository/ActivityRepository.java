package com.jacekg.teamfinder.venueservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacekg.teamfinder.venueservice.model.ActivityType;

public interface ActivityRepository extends JpaRepository<ActivityType, Long> {
	public ActivityType findByName(String name);
}
