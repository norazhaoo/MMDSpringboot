package com.mmd.MMDSpringboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.ResourceDao;
import com.mmd.MMDSpringboot.exception.ResourceNotFoundException;
import com.mmd.MMDSpringboot.model.Resource;

@RestController
@RequestMapping("/api/v1")
public class ResourceController {

	@Autowired
	private ResourceDao resourceDao;

	@GetMapping("/resource")
	public List<Resource> getResources() {
		return resourceDao.findAll();
	}

    @GetMapping("/resource/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable(value = "id") int id)
        throws ResourceNotFoundException {
        Resource resource = resourceDao.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(resource);
    }
    
	@PostMapping("/resource")
	public Resource addResource(@Valid @RequestBody Resource resource) {
		return resourceDao.save(resource);
	}

	@PutMapping("/resource/{id}")
//	public Resource saveOrUpdateResource(@RequestBody Resource resource) {
//		resourceDao.save(resource);
//		return resource;
//	}
    public ResponseEntity<Resource> updateResource(@PathVariable(value = "id") int id,
            @Valid @RequestBody Resource project) throws ResourceNotFoundException {
           Resource resource = resourceDao.findById(id) 
           .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

           resource.setId(project.getId());
           resource.setResource_code(project.getResource_code());
           resource.setResource_name(project.getResource_name());
           final Resource updatedResource = resourceDao.save(resource);
           return ResponseEntity.ok(updatedResource);
       }
	
    @DeleteMapping("/resource/{id}")
    public Map<String, Boolean> deleteResource(@PathVariable(value = "id") int id)
         throws ResourceNotFoundException {
        Resource resource = resourceDao.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        resourceDao.delete(resource);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
} 


