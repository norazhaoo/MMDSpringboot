package com.mmd.MMDSpringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.ResourceDao;
import com.mmd.MMDSpringboot.model.Resource;


@RestController
public class ProjectController {
	
	@Autowired
	ResourceDao resourceDao;
	
	@GetMapping(path="/resource")
	public List<Resource> getResources(){
		return resourceDao.findAll();
	}

}
