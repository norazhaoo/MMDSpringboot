package com.mmd.MMDSpringboot.jwt;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usermodel, Long> {
	
	public Usermodel findByUsername(String username);
	
}