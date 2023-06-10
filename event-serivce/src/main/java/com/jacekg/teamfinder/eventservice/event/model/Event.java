package com.jacekg.teamfinder.eventservice.event.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
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
@Table(name = "event")
@DiscriminatorColumn(name = "event_type")
public abstract class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "activity_type", nullable = false)
	protected ActivityType activityType;
	
	@Column(name = "date", nullable = false)
	private LocalDateTime date;
	
	@Column(name = "price", nullable = false)
	private float price;
	
	@Column(name = "venue_id", nullable = false)
	private long venueId;
	
	@Column(name = "creator_user_id", nullable = false)
	private long creatorUserId;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "event_id")
	private List<EventUser> users = new ArrayList<>();

	public Event(String name, LocalDateTime date, float price, Long venueId, Long creatorUserId) {
		this.name = name;
		this.date = date;
		this.price = price;
		this.venueId = venueId;
		this.creatorUserId = creatorUserId;
//		addUserId(creatorUserId);
	}
	
	public void addUserId(long userId) {
		this.users.add(new EventUser(userId, this.id));
	}
	
	public List<EventUser> getUsers() {
		return users;
	}
	
	public List<Long> getUsersId() {
		return this.users.stream().map(eventUser -> eventUser.getUserId()).collect(Collectors.toList());
	}
}
