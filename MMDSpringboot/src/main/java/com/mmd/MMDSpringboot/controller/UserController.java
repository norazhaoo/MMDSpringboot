package com.mmd.MMDSpringboot.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.UserDao;
import com.mmd.MMDSpringboot.model.User;

@RestController
public class UserController {

	UserDao userDao;
	
	@RequestMapping("/user/{username}")
	public Optional<User> getUserByUsername(@PathVariable("username") int username) {
		return userDao.getUserById(username);
	}
	
}