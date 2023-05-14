package com.jacekg.teamfinder.eventservice.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacekg.teamfinder.eventservice.event.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	
}
