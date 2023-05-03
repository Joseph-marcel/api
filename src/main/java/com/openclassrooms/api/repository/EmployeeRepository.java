package com.openclassrooms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.api.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
