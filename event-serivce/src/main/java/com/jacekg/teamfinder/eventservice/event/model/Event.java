package com.jacekg.teamfinder.eventservice.event.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "events")
public abstract class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "activityType", nullable = false)
	protected String activityType;
	
	@Column(name = "date", nullable = false)
	private LocalDateTime date;
	
	@Column(name = "price", nullable = false)
	private float price;
	
	@Column(name = "venueId", nullable = false)
	private long venueId;
	
	@Column(name = "creatorUserId", nullable = false)
	private long creatorUserId;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "event_id")
	private List<EventUser> usersId = new ArrayList<>();

	public Event(String name, String activityType, LocalDateTime date, float price, Long venueId, Long creatorUserId) {
		this.name = name;
		this.activityType = activityType;
		this.date = date;
		this.price = price;
		this.venueId = venueId;
		this.creatorUserId = creatorUserId;
	}
	
	
}
