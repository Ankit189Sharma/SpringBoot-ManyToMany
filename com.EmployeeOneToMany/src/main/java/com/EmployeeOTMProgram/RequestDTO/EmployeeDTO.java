package com.EmployeeOTMProgram.RequestDTO;

import com.EmployeeOTMProgram.Department;

public class EmployeeDTO {

	String name;
	private Department department;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
