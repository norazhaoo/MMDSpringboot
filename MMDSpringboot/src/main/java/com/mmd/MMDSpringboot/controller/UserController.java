package com.mmd.MMDSpringboot.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.UserDao;
import com.mmd.MMDSpringboot.model.User;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;
	
	@RequestMapping("/users")
	@ResponseBody
	public String getUsers() {
		return userDao.findAll().toString();
	}
	
}