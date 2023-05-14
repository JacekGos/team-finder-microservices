package com.jacekg.teamfinder.eventservice.event.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Builder;


@Entity
public class FootballEvent extends Event {
	
	@Builder
	public FootballEvent(String name, String activityType, LocalDateTime date, float price, long venueId, long creatorUserId) {
		super(name, activityType, date, price, venueId, creatorUserId);
		this.activityType = "FOOTBALL";
	}
}
