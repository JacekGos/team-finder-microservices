package com.jacekg.teamfinder.userservice.service;

import java.util.List;

import com.jacekg.teamfinder.userservice.model.Role;
import com.jacekg.teamfinder.userservice.model.User;


public interface UserService {

	public List<User> getAllUsers();

	public List<Role> getAllRoles();
}
