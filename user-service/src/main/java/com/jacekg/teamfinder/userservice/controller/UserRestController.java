package com.jacekg.teamfinder.userservice.controller;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacekg.teamfinder.userservice.dto.UserResponse;
import com.jacekg.teamfinder.userservice.model.Role;
import com.jacekg.teamfinder.userservice.service.UserService;
import com.jacekg.teamfinder.userservice.utils.ModelConverter;

@RestController
@RequestMapping("/v1/")
public class UserRestController {
	
	private UserService userService;
	private ModelConverter modelConverter;
	
	public UserRestController(UserService userService, ModelConverter modelConverter) {
		this.userService = userService;
		this.modelConverter = modelConverter;
	}
	
	@GetMapping("/roles")
	public ResponseEntity<List<Role>> getAllEvents() {
		
		return status(HttpStatus.SC_OK).body(userService.getAllRoles());
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		return status(HttpStatus.SC_OK).body(userService.getAllUsers().stream().map(user -> modelConverter.convertToResponse(user)).collect(Collectors.toList()));
	}
}
