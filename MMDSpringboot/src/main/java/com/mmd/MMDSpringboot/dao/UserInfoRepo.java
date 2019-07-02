package com.mmd.MMDSpringboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmd.MMDSpringboot.model.Userdetails;

public interface UserInfoRepo extends JpaRepository<Userdetails, Integer>{

	List<Userdetails> findByUname(String uname);
	
}
