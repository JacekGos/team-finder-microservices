package com.jacekg.teamfinder.venueservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Entity
@Table(name = "activity_type")
public class ActivityType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "activities")
	private Set<Venue> venues = new HashSet<>();

	@Override
	public String toString() {
		return name;
	}
	
	public void addVenue(Venue venue) {
		this.venues.add(venue);
	}
	
	public String getName() {
		System.out.println("activity name: " + this.name);
		return this.name;
	}
}
