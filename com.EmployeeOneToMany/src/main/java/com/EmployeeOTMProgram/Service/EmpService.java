package com.EmployeeOTMProgram.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeOTMProgram.Department;
import com.EmployeeOTMProgram.Employee;
import com.EmployeeOTMProgram.Repo.DeptRepo;
import com.EmployeeOTMProgram.Repo.EmpRepo;
import com.EmployeeOTMProgram.RequestDTO.EmployeeDTO;
import com.EmployeeOTMProgram.ResponseDTO.BaseResponse;

@Service
public class EmpService {

	@Autowired
	EmpRepo empRepo;
	
	@Autowired
	DeptRepo deptRepo;
	
	public List<Employee> getAllEmployees()
	{
		return empRepo.findAll();
		
	}
	
	public BaseResponse addEmployee(EmployeeDTO employee,BaseResponse res)
	{
		try {
		/*
		 * Department
		 * dpt=deptRepo.findById(employee.getDepartment().getId()).orElse(null);
		 * if(dpt==null) { dpt=new Department(); }
		 */
			Employee empModel=new Employee();
			
			empModel.setName(employee.getName());
			
			Department dpt=new Department();
			
			dpt.setDeptname(employee.getDepartment().getDeptname());
			
			empModel.setDepartment(dpt);
			//Employee e=new Employee();
			
			empModel=empRepo.save(empModel);
			
			return res;
		
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	public Employee editEmployees(Employee entity)
	{
		return empRepo.save(entity);
	}
	
	public void deleteEmployees(Integer id)
	{
		empRepo.deleteById(id);
	}
	public List<Department> viewAll()
	{
		return deptRepo.findAll();
	}
	
	
	//id nhi mil ri
	public Employee findUserById(Integer id)
	{
	//	Employee getValue=empRepo.findById(id);
		Employee getValue=empRepo.findOneById(id);
		return getValue;
	}
}
