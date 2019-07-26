package com.mmd.MMDSpringboot.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mmd.MMDSpringboot.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    //check if username exists, if not there throw ResponseStatusException
		try {
	    	Usermodel usermodel = userRepository.findByUsername(username);
	    	usermodel.getUsername();
	    } catch (Exception ex) {
	        throw new ResponseStatusException(
	          HttpStatus.NOT_FOUND, "username: "+ username+" is not a registered username", ex);
	    }
		
		//needed for UserDetails for spring security
		Usermodel user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public Usermodel save(UserDTO user) {
		
		//checks for existing username, if found throw a ResponseStatusException 500 error code
	    try {
	    	Usermodel usermodel = userRepository.findByUsername(user.getUsername());
	    	if(usermodel != null) {
	    		//username exists, force throw an exception
		        throw new ResponseStatusException(null);
	    	}
	    } catch (Exception ex) {
	        throw new ResponseStatusException(
		  	          HttpStatus.INTERNAL_SERVER_ERROR, "username: "+ user.getUsername()+" already exists", ex);
	    }
	    
	    //username is fine, can add to database
			Usermodel newUser = new Usermodel();
			newUser.setUsername(user.getUsername());
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			return userRepository.save(newUser);	
	}
}