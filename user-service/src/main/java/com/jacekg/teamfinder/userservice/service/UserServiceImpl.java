package com.jacekg.teamfinder.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jacekg.teamfinder.userservice.model.Role;
import com.jacekg.teamfinder.userservice.model.User;
import com.jacekg.teamfinder.userservice.repository.RoleRepository;
import com.jacekg.teamfinder.userservice.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;

	@Override
	public List<User> getAllUsers() {
		return null;
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	
	
}
