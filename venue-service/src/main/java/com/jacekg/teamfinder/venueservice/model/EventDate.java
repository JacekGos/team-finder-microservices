package com.jacekg.teamfinder.venueservice.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "venue_event_date")
@NoArgsConstructor
@Getter
//@ToString
public class EventDate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "venue_id")
	private Long venueId;
	
	@Column(name = "date", nullable = false)
	private Date date;

	public EventDate(Long venueId, Date date) {
		this.venueId = venueId;
		this.date = date;
	}
}	
