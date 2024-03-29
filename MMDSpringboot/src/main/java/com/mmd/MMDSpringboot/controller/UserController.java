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
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.UserDao;
import com.mmd.MMDSpringboot.model.User;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;
	
	@RequestMapping
	public String greeting(@RequestParam(value="name2", required=false, defaultValue="World")String nValue, Model model) {
		Connection testConnection = getConnectionToDB();
				model.addAttribute("name2", nValue);
				return "greeting";
	}
	
	public Connection getConnectionToDB() {
	try {
		Connection conn = DriverManager.getConnection("hibernatemvc.cgtdexfjpqql.us-east-2.rds.amazonaws.com", "magicmagentadog", "Vipintherobot1");
		return conn;
	}catch(Exception e) {
		return null;
	}
	}
	
	@RequestMapping("/user/{username}")
	public Optional<User> getUserByUsername(@PathVariable("username") int id) {
		return userDao.getUserById(id);
	}
	
	@GetMapping(path="/users")
	public List<User> getUsers() {
		System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPp"+userDao.findAll());
		return userDao.findAll();
	}
	
}