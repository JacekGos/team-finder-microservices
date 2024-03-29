package com.jacekg.teamfinder.userservice.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Builder
@Entity
@Table(name = "\"user\"")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "username", nullable = false )
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "is_enabled", nullable = false)
	private boolean isEnabled;

	@Column(name = "is_non_expired", nullable = false)
	private boolean isNonExpired;

	@Column(name = "is_credentials_non_expired", nullable = false)
	private boolean isCredentialsNonExpired;

	@Column(name = "is_non_locked", nullable = false)
	private boolean isNonLocked;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", 
		joinColumns = { @JoinColumn(name = "user_id") },
		inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Collection<Role> roles;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private final Set<UserEvent> events = new HashSet<>();
	
	public List<String> getRolesNames() {
		return this.roles.stream().map(role -> role.getName()).collect(Collectors.toList());
	}
	
	public List<Long> getEventsId() {
		return this.events.stream().map(userEvent -> userEvent.getEventId()).collect(Collectors.toList());
	}
	
	public void addRole(Role role) {
		this.roles.add(role);
	}
	
	public void addEvent(long eventId) {
		this.events.add(new UserEvent(this.id, eventId));
	}
}
