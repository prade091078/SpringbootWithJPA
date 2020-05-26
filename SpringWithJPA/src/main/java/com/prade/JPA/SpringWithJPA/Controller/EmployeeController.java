package com.prade.JPA.SpringWithJPA.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prade.JPA.SpringWithJPA.Entity.Employee;

import com.prade.JPA.SpringWithJPA.Service.EmployeeService;

@RestController
@RequestMapping({ "v1/" })
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("getallemp")
	public List<Employee> getAllEmployees(){
		return empService.findAll();
	}
	
	@GetMapping("getemp")
	public Optional<Employee> getEmployee(int id){
		return empService.findById(id);
	}
	
	@DeleteMapping("delemp")
	public void deleteEmployee(int id){
		empService.deleteById(id);
	}
	
	@PostMapping("addemp")
	public void addEmployee(@Valid @RequestBody Employee emp){
		empService.addEmp(emp);
	}
}
