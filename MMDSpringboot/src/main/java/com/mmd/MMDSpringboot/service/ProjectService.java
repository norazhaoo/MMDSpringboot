package com.mmd.MMDSpringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmd.MMDSpringboot.dao.ResourceDao;
import com.mmd.MMDSpringboot.model.Resource;
@Service

public class ProjectService implements ProjectServiceInterface{
	@Autowired
	private ResourceDao resourceDao;

	@Override
	    public List<Resource> getResources() { 
	        return resourceDao.findAll();
	    }

	@Override
	    public Optional<Resource> getResource( int id) {

	        return resourceDao.findById(id);
	    }

	@Override
	    public Resource addResource(Resource resource) {
	        return resourceDao.save(resource);
	    }
	   

	@Override
	    public Resource saveOrUpdateResource( Resource resource) {
	        resourceDao.save(resource);
	        return resource;
} 
}
