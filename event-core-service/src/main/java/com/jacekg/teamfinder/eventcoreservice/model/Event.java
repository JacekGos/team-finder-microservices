package com.jacekg.teamfinder.eventcoreservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Event {
	
	private int id;
	private String name;
	private String port;
	
	public Event(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
