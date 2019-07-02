package com.user.userinfo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.user.userinfo.model.Userdetails;


public interface UserInfoRepo extends CrudRepository<Userdetails, Integer>{	
	List<Userdetails> findByUname(String uname);
}

	
	