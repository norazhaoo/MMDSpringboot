package com.mmd.MMDSpringboot.employee;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

//	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	@GetMapping
	public List<Employee> firstPage() {
		return employeeService.getAllEmployees();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		employeeService.deleteEmployeeById(id);
	}

	@PostMapping
	public Employee create(@RequestBody Employee user) {
		return employeeService.createEmployee(user);
	}


}