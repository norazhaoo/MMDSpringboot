package com.jason.SpringBootJPASQLServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.SpringBootJPASQLServer.dao.DataRepo;
import com.jason.SpringBootJPASQLServer.model.Data;

@Controller
public class DataController {

		@Autowired
		DataRepo repo;
		
		@RequestMapping("/data")
		@ResponseBody
		public List<Data> getData() {
			
			return repo.findAll();
			
			
		}
}
