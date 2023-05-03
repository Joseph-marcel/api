package com.openclassrooms.api.service;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.api.model.Employee;
import com.openclassrooms.api.repository.EmployeeRepository;

import lombok.Data;

@Service
@Data
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	
	
    public Iterable<Employee> getAll(){
    	return employeeRepo.findAll();
    }
    
    
    public Employee getEmployeeById(long id) {
    	return employeeRepo.findById(id).orElse(null);
    }
    
    
    public Employee createEmployee(Employee employee) {
    	
    	boolean valid = EmailValidator.getInstance().isValid(employee.getEmail());
    	try{
    		if(valid) {
    			employee.setEmail(employee.getEmail());
    		}
        }catch(Exception $e){
            System.out.println($e);
        } 
    	 
    	
    	return employeeRepo.save(employee);
    }
    
    
    public void deleteEmployee(long id) {
    	employeeRepo.deleteById(id);
    }
    
    
    public Employee updateEmployee(Employee employee,Long id) {
    	Employee existingEmployee = this.getEmployeeById(id);
    	existingEmployee.setEmail(employee.getEmail());
    	existingEmployee.setFirstName(employee.getFirstName());
    	existingEmployee.setLastName(employee.getLastName());
    	existingEmployee.setPassword(employee.getPassword());
    	employeeRepo.save(existingEmployee);
    	
    	return existingEmployee;
    }
    
    
}
