package com.jacekg.teamfinder.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacekg.teamfinder.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
