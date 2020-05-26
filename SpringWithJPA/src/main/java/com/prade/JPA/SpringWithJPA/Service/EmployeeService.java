package com.prade.JPA.SpringWithJPA.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prade.JPA.SpringWithJPA.Entity.Employee;
import com.prade.JPA.SpringWithJPA.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepository;

    public Employee addEmp(Employee obj) {
        return empRepository.save(obj);
    }

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empRepository.findAll();
	}

	public Optional<Employee> findById(int id) {
		// TODO Auto-generated method stub
		return empRepository.findById(id);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		empRepository.deleteById(id);
	}
}