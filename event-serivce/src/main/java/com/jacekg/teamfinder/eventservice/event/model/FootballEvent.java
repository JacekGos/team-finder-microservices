package com.jacekg.teamfinder.eventservice.event.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("footballEvent")
//@NoArgsConstructor
@AllArgsConstructor
public class FootballEvent extends Event {

	@Builder
	public FootballEvent(String name, ActivityType activityType, LocalDateTime date, float price, long venueId,	long creatorUserId, List<EventUser> users) {
		super(name, date, price, venueId, creatorUserId);
		this.activityType = ActivityType.FOOTBALL;
	}
}
