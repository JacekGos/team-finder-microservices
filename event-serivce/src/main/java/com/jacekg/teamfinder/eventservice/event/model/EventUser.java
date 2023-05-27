package com.jacekg.teamfinder.eventservice.event.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "event_user")
@NoArgsConstructor
@ToString
public class EventUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "event_id")
	private Long eventId;

	
	public EventUser(Long userId, Long eventId) {
		this.userId = userId;
		this.eventId = eventId;
	}

}
