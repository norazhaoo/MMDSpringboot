package com.mmd.MMDSpringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.mmd.MMDSpringboot.model.Resource;

public interface ProjectServiceInterface {
	public List<Resource> getResources();
	 
	public Optional<Resource> getResource(@PathVariable("id") int id);
	 
	public Resource addResource(@RequestBody Resource resource);
	 
	public Resource saveOrUpdateResource(@RequestBody Resource resource);
	 
}