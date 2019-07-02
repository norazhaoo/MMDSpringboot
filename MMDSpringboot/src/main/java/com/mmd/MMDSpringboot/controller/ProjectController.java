package com.mmd.MMDSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.ProjectDao;

@RestController
public class ProjectController{
	
	@Autowired
	ProjectDao projectDao;
	
	
}