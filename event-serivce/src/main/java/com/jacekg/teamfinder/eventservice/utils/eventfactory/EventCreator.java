package com.jacekg.teamfinder.eventservice.utils.eventfactory;

import com.jacekg.teamfinder.eventservice.dto.EventRequest;
import com.jacekg.teamfinder.eventservice.event.model.BasketballEvent;
import com.jacekg.teamfinder.eventservice.event.model.BicycleEvent;
import com.jacekg.teamfinder.eventservice.event.model.Event;
import com.jacekg.teamfinder.eventservice.event.model.FootballEvent;
import com.jacekg.teamfinder.eventservice.event.model.TennisEvent;
import com.jacekg.teamfinder.eventservice.event.model.VolleyballEvent;
import com.jacekg.teamfinder.eventservice.exceptions.CreateEventException;

public class EventCreator extends EventBaseCreator {

	@Override
	public Event createVenue(EventRequest event) {
		
		Event newEvent = null;
		
		switch (event.getActivityType()) {
		case "football": 
			newEvent = FootballEvent.builder()
				.name(event.getName())
				.price(event.getPrice())
				.creatorUserId(event.getCreatorUserId())
				.date(event.getDate())
				.venueId(event.getVenueId())
				.build();
			break;
		case "volleyball": 
			newEvent = VolleyballEvent.builder()
				.name(event.getName())
				.price(event.getPrice())
				.creatorUserId(event.getCreatorUserId())
				.date(event.getDate())
				.venueId(event.getVenueId())
				.build();
			break;
		case "basketball": 
			newEvent = BasketballEvent.builder()
				.name(event.getName())
				.price(event.getPrice())
				.creatorUserId(event.getCreatorUserId())
				.date(event.getDate())
				.venueId(event.getVenueId())
				.build();
			break;
		case "tennis": 
			newEvent = TennisEvent.builder()
				.name(event.getName())
				.price(event.getPrice())
				.creatorUserId(event.getCreatorUserId())
				.date(event.getDate())
				.venueId(event.getVenueId())
				.build();
			break;
		case "bicycle": 
			newEvent = BicycleEvent.builder()
				.name(event.getName())
				.price(event.getPrice())
				.creatorUserId(event.getCreatorUserId())
				.date(event.getDate())
				.venueId(event.getVenueId())
				.build();
			break;
		default:
			throw new CreateEventException("No type(" + event.getActivityType() + ")" + " of Event exists");
		}
		
		return newEvent;
	}
}
