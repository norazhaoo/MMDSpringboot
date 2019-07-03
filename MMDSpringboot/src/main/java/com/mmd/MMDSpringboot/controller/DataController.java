package com.mmd.MMDSpringboot.controller;

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

@RestController
public class DataController {

	@Autowired
	DataDao dataDao;
	
    @RequestMapping("/data/{id}")
    public List<Data> getData(@PathVariable("projectid") int id) {
        return dataDao.findAllByProjectid(id);
    }
	
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
