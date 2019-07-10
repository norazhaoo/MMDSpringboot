package com.mmd.MMDSpringboot.userinfo;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.util.ErrorException;
import com.mmd.MMDSpringboot.util.HashPW;

@RestController
public class UserInfoController {
	@Autowired
	UserInfoRepo userRepo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping("/userReg")
	public Userdetails userReg(@RequestBody Userdetails user) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		if((userRepo.findByUname(user.getUname()).size()) > 0) {
			throw new ErrorException("This user name has been used, please try another one.");
		}
		
		int userCount = (int)userRepo.count();
		userCount++;
		
		user.setId(userCount);
		
		SecureRandom random = new SecureRandom();
		byte[] saltRandom = new byte[16];
		random.nextBytes(saltRandom);
		
		user.setSalt(saltRandom);
		
		HashPW urPW = new HashPW();		
		String hashPW = Base64.getEncoder().encodeToString(urPW.HashPW(user.getPass(), user.getSalt()));
		
		user.setPass(hashPW);
		
		userRepo.save(user);
		return user;
	}
	
	
	@RequestMapping("/getUser/{uname}")
	public List<Userdetails> getUser(@PathVariable("uname") String uname) {
		List<Userdetails> user = userRepo.findByUname(uname);
		return user;
	}
	
	@PostMapping("/userLogin")
	public Userdetails userLogin(@RequestBody Userdetails user) throws NoSuchAlgorithmException, InvalidKeySpecException{
		Userdetails userTest = userRepo.findByUname(user.getUname()).get(0);
		
		byte[] saltTest = userTest.getSalt();
        
		HashPW urPWTest = new HashPW();		
        String hashPWTest = Base64.getEncoder().encodeToString(urPWTest.HashPW(user.getPass(), saltTest));
		
		if(!hashPWTest.equals(userTest.getPass())) {
			throw new ErrorException("Invalid username or password, please try again.");
		}
		
		return userTest;
	}
}