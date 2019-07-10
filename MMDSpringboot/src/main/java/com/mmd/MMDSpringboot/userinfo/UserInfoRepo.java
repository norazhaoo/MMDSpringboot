package com.mmd.MMDSpringboot.userinfo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<Userdetails, Integer>{

	List<Userdetails> findByUname(String uname);
	
}
