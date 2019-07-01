package com.user.userinfo.controller;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.userinfo.HashPW;
import com.user.userinfo.dao.UserInfoRepo;
import com.user.userinfo.model.Userdetails;

@RestController
public class UserInfoController {
	@Autowired
	UserInfoRepo userRepo;
	
	
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping("/userReg")
	public Userdetails userReg(Userdetails user) throws NoSuchAlgorithmException, InvalidKeySpecException {
		SecureRandom random = new SecureRandom();
		byte[] saltRandom = new byte[16];
		random.nextBytes(saltRandom);
		
		user.setSalt(saltRandom);
		
		HashPW urPW = new HashPW();		
		String hashPW = new String(urPW.HashPW(user.getPass(), user.getSalt()));
		
		user.setPass(hashPW);
		
		userRepo.save(user);
		return user;
	}

}
