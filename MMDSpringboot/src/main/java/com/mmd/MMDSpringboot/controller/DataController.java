package com.mmd.MMDSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.DataDao;
import com.mmd.MMDSpringboot.model.Data;

@RestController
public class DataController {

	@Autowired
	DataDao dataDao;
	
	@PostMapping("/addData")
	public Data addData(@RequestBody Data data) {
		return dataDao.save(data);
		
	}
	
	
}
