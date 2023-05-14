package com.jacekg.teamfinder.eventservice.event.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventResponse {
	
	private long id;
	
	private String name;
	
	private String activityType;
	
	private LocalDateTime date;
	
	private float price;
	
	private Long venueId;
	
	private Long creatorUserId;
	
	private List<Integer> usersId = new ArrayList<>();
}
