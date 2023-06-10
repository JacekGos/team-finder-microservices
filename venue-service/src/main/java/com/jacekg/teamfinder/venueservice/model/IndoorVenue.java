package com.jacekg.teamfinder.venueservice.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("indoorVenue")
@NoArgsConstructor
public class IndoorVenue extends Venue {
	
	@Builder
	public IndoorVenue(String name, float price, Set<ActivityType> activities, String address) {
		super(name, price, activities, address);
	}
}
