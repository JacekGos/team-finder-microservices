package com.jacekg.teamfinder.userservice.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponse {
	
	private long id;
	
	private String username;
	
	private String email;
	
	private boolean isEnabled;

	private boolean isNonExpired;

	private boolean isCredentialsNonExpired;

	private boolean isNonLocked;
	
	private List<String> roles = new ArrayList<>();

	private List<Long> eventsId = new ArrayList<>();
}
