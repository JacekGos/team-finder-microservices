package com.jacekg.teamfinder.eventservice.event.model;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("basketballEvent")
@NoArgsConstructor
public class BasketballEvent extends Event {

	@Builder
	public BasketballEvent(String name, LocalDateTime date, float price, long venueId,
			long creatorUserId) {
		super(name, date, price, venueId, creatorUserId);
		this.activityType = ActivityType.BASKETBALL;
	}
}
