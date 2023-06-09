package com.jacekg.teamfinder.venueservice.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jacekg.teamfinder.venueservice.model.ActivityType;

public interface ActivityRepository extends JpaRepository<ActivityType, Long> {
	public Optional<ActivityType> findByName(String name);
	
	@Query("FROM ActivityType WHERE name IN :names")
	public Optional<List<ActivityType>> findByNames(@Param("names") Set<String> names);
}
