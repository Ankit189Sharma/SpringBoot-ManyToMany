package com.EmployeeOTMProgram.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeOTMProgram.Department;

@Repository
public interface DeptRepo extends JpaRepository<Department, Integer>{

}
