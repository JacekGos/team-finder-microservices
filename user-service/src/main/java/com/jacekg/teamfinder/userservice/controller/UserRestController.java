package com.jacekg.teamfinder.userservice.controller;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacekg.teamfinder.userservice.model.Role;
import com.jacekg.teamfinder.userservice.service.UserService;

@RestController
@RequestMapping("/v1/")
public class UserRestController {
	
	private UserService userService;
	
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/roles")
	public ResponseEntity<List<Role>> getAllEvents() {
		
		return status(HttpStatus.SC_OK).body(userService.getAllRoles());
	}
}
