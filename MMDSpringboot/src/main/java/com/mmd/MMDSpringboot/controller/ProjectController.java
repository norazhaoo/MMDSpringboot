package com.mmd.MMDSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.ProjectDao;
import com.mmd.MMDSpringboot.model.Resource;



@RestController 
public class ProjectController{
	
	@Autowired
	ProjectDao projectDao;
	
//	@PostMapping("/resource")
//	public Resource addResource(Resource resource) {
//		projectDao.save(resource);
//		return resource;
//	}
//	
	//@GetMapping("/Resource/{resource_name}")
	//public Optional<Resource> filterResource(@PathVariable("resource_name")
	//String resource_name) {
	//return resourceDao.findResourceNameLike
}
