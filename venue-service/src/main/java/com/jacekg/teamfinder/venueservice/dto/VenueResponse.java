package com.jacekg.teamfinder.venueservice.dto;

import java.util.Date;
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
public class VenueResponse {
	
private Long id;
	
	private String name;
	
	private float price;
	
	private String address;
	
	private String lat;
	
	private String lng;
	
	private List<Date> eventDates;
	
	private List<String> activities;
}
