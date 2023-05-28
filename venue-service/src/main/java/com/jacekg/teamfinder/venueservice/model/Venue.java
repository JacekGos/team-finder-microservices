package com.jacekg.teamfinder.venueservice.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Entity
@Table(name = "venues")
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
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "venue_id")
	private List<EventDate> eventDates;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "venue_activity_type", 
			joinColumns = { @JoinColumn(name = "venue_id") },
			inverseJoinColumns = { @JoinColumn(name = "activity_type_id") })
	private Set<ActivityType> activities = new HashSet<>();

	public Venue(String name, float price, Set<ActivityType> activities) {
		this.name = name;
		this.price = price;
		this.activities = activities;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
