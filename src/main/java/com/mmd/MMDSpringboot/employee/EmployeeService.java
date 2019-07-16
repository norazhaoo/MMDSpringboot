package com.mmd.MMDSpringboot.employee;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Long saveEmployee(String name, String designation, double salary) {
		Employee employee = new Employee();
		employee.setName(name);
		employee.setDesignation(designation);
		employee.setSalary(salary);
		return employeeRepository.save(employee).getEmpId();
	}

	public void deleteEmployeeById(Long id) {
		Employee deletedEmp = employeeRepository.getOne(id);
		employeeRepository.delete(deletedEmp);
	}

	public Employee createEmployee(Employee user) {
		return employeeRepository.save(user);
	}
	
	
	
}
