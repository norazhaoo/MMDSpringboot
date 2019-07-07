package com.mmd.MMDSpringboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.MMDSpringboot.dao.DataDao;
import com.mmd.MMDSpringboot.model.Data;
import com.mmd.MMDSpringboot.model.Resource;

@RestController
public class DataController {

	@Autowired
	DataDao dataDao;
	
    @RequestMapping("/data")
    public List<Data> getAllData() {
    	return dataDao.findAll();
    }
    
//    @RequestMapping("/data/{projectid}")
//    public List<Data> findAllByProjectid(@PathVariable("projectid") int projectid) {
//    	List<Data> specificProject = dataDao.findByDataIdProjectid(projectid);
////    	ArrayList<String> arrayOfColumns = new ArrayList<String>();
////    	for(Data tempData: specificProject) {
////    		arrayOfColumns.add(tempData.getColumnname());
////    	}
//    	return specificProject;
//    }
	
	@PostMapping("/addData")
	public Data addData(@RequestBody Data data) {
		return dataDao.save(data);
	}
	
    @PutMapping(path = "/updateData", consumes = {"application/json"})
    public Data saveOrUpdateData(@RequestBody Data data) {
    	dataDao.save(data);
        return data;
    }
	
	
}
