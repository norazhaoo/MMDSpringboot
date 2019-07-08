package com.mmd.MMDSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.ProjectDao;
=======
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

>>>>>>> Stashed changes
import com.mmd.MMDSpringboot.model.Resource;
import com.mmd.MMDSpringboot.service.ProjectService;


<<<<<<< Updated upstream

@RestController 
public class ProjectController{
	
	@Autowired
	ProjectDao projectDao;
=======
@RestController
public class ProjectController {
	@Autowired
<<<<<<< HEAD
	private ProjectService projectService;

	@PostMapping
	public Resource addResource(@RequestBody Resource resource){
	    return projectService.addResource(resource);
	}

	@GetMapping(path = {"/resource/{id}"})
	public Optional<Resource> getResource(@PathVariable("id") int id){
	    return projectService.getResource(id);
	}

	@PutMapping
	public Resource saveOrUpdateResource(@RequestBody Resource resource){
	    return projectService.saveOrUpdateResource(resource);
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
    public Resource addResource(@RequestBody Resource resource) {
        return resourceDao.save(resource);
    }
   

    @PutMapping(path = "/resource", consumes = {"application/json"})
    public Resource saveOrUpdateResource(@RequestBody Resource resource) {
        resourceDao.save(resource);
        return resource;
    }
	
>>>>>>> develop


	@GetMapping("/resource")
	public List<Resource> getResources(){
	    return projectService.getResources();
	}

>>>>>>> Stashed changes
	
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
