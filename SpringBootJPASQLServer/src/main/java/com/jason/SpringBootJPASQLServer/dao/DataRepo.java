package com.jason.SpringBootJPASQLServer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jason.SpringBootJPASQLServer.model.Data;

	public interface DataRepo extends JpaRepository<Data, Integer>{
		List<Data> findAll();
		
		//List<data> findByAidGreaterThan(int aid);
		
		//@Query("from data where tech=?1 order by aname")
		//List<data> findByTechSorted(String tech);
	}

