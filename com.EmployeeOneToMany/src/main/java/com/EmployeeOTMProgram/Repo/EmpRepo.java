package com.EmployeeOTMProgram.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeOTMProgram.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer>{

	Employee findOneById(Integer id);
}
