package com.jacekg.teamfinder.userservice.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<User> getAllUsers() {
		
		Optional<Role> foundRole = roleRepository.findByName("ADMIN");
		Role role = Optional.ofNullable(foundRole)
				.get()
				.orElse(null);

//		User newUser = User.builder()
//				.username("testUser2")
//				.password(passwordEncoder.encode("test"))
//				.email("test@email.com")
//				.roles(Arrays.asList(role))
//				.build();
//		
//		userRepository.saveAndFlush(newUser);
//		
//		newUser.addEvent(3);
//		newUser.addEvent(4);
		
		List<User> users = userRepository.findAll();
		users.forEach(user -> System.out.println("user: " + user.toString()));
		return users;
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	
	
}
