package com.mmd.MMDSpringboot.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> b076607a504fa59c75b3c9872f9942f74eeab3bf
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.ProjectDao;

@RestController
public class ProjectController{
	
	@Autowired
<<<<<<< HEAD
	ProjectDao projectDao;
	
	
}
=======
    ResourceDao resourceDao;

    @GetMapping("/resource")
    public List<Resource> getResources() {
        return resourceDao.findAll();
    }

    @RequestMapping("/resource/{id}")
    public Optional<Resource> getResource(@PathVariable("id") int id) {

        return resourceDao.findById(id);

    }
    
    @PostMapping("/resource")
    public Resource addResource(Resource resource) {
        return resourceDao.save(resource);
    }
    
    @PutMapping(path = "/resource", consumes = {"application/json"})
    public Resource saveOrUpdateResource(@RequestBody Resource resource) {
        resourceDao.save(resource);
        return resource;
    }
	

}
>>>>>>> b076607a504fa59c75b3c9872f9942f74eeab3bf
