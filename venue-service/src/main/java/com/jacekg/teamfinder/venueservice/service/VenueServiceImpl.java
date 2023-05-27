package com.jacekg.teamfinder.venueservice.service;

import org.springframework.stereotype.Service;

import com.jacekg.teamfinder.venueservice.repository.VenueRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VenueServiceImpl implements VenueService {
	
	private VenueRepository repository;
}
