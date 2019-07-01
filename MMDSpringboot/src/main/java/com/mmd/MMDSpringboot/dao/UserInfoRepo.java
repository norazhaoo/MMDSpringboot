package com.mmd.MMDSpringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmd.MMDSpringboot.model.Userdetails;

public interface UserInfoRepo extends JpaRepository<Userdetails, Integer>{

	
}
