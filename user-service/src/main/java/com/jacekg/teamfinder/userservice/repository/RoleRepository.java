package com.jacekg.teamfinder.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacekg.teamfinder.userservice.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
