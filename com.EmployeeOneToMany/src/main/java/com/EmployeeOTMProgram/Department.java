package com.EmployeeOTMProgram;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String deptname;
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Employee> employees;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Department(Integer id, String deptname, List<Employee> employees) {
		super();
		this.id = id;
		this.deptname = deptname;
		this.employees = employees;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptname=" + deptname + ", employees=" + employees + "]";
	}

	
}
