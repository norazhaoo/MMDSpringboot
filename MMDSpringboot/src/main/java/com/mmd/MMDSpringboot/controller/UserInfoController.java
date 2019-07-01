package com.mmd.MMDSpringboot.controller;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.HashPW;
import com.mmd.MMDSpringboot.dao.UserInfoRepo;
import com.mmd.MMDSpringboot.model.Userdetails;

@RestController
public class UserInfoController {
	@Autowired
	UserInfoRepo userRepo;

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