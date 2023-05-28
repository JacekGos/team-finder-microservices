package com.jacekg.teamfinder.venueservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "venue_event_date")
@NoArgsConstructor
@ToString
public class EventDate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "venue_id")
	private Long venueId;
	
	@Column(name = "date", nullable = false)
	private LocalDateTime date;

	public EventDate(Long venueId, LocalDateTime date) {
		this.venueId = venueId;
		this.date = date;
	}
}	
