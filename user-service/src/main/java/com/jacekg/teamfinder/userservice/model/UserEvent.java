package com.jacekg.teamfinder.userservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@ToString
@Getter
@Entity
@Table(name = "user_event")
public class UserEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "event_id")
	private Long eventId;

	public UserEvent(Long userId, Long eventId) {
		this.userId = userId;
		this.eventId = eventId;
	}
}
