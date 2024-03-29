package com.jacekg.teamfinder.venueservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.locationtech.jts.geom.Point;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venue")
@DiscriminatorColumn(name = "venue_type")
public abstract class Venue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false)
	private float price;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(columnDefinition = "geometry")
	private Point location;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "venue_id")
	private List<EventDate> eventDates = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "venue_activity_type", 
			joinColumns = { @JoinColumn(name = "venue_id") },
			inverseJoinColumns = { @JoinColumn(name = "activity_type_id") })
	private Set<ActivityType> activities = new HashSet<>();

	public Venue(String name, float price, Set<ActivityType> activities, String address) {
		this.name = name;
		this.price = price;
		this.activities = activities;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	public List<Date> getDates() {
		return this.eventDates.stream().map(eventDate -> eventDate.getDate()).collect(Collectors.toList());
	}
	
	public List<String> getActivitiesNames() {
		return this.activities.stream().map(activity -> activity.getName()).collect(Collectors.toList());
	}
	
	public void addActivityType(ActivityType activityType) {
		this.activities.add(activityType);
		activityType.addVenue(this);
	}
	
	public void addEventDate(Date date) {
		this.eventDates.add(new EventDate(this.id, date));
	}
	
	public String getLng() {
		return String.valueOf(this.location.getX());
	}
	
	public String getLat() {
		return String.valueOf(this.location.getY());
	}
}
