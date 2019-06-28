package com.mmd.MMDSpringboot.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmd.MMDSpringboot.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	Optional<User> getUserById(int id);

}
