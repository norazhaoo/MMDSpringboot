package com.mmd.MMDSpringboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.UserDao;

@RestController
public class UserController {

	@Autowired
	UserDao userDao;
	
	@RequestMapping("/users")
	@ResponseBody
	public String getUsers() {
		return userDao.findAll().toString();
	}
	
}