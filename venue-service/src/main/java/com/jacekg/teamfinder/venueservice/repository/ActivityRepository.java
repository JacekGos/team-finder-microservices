package com.jacekg.teamfinder.venueservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacekg.teamfinder.venueservice.model.ActivityType;

public interface ActivityRepository extends JpaRepository<ActivityType, Long> {
	public Optional<ActivityType> findByName(String name);
}
