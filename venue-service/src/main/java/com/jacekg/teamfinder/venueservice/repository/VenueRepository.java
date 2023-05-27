package com.jacekg.teamfinder.venueservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacekg.teamfinder.venueservice.model.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {

}
