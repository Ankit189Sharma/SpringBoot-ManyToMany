package com.EmployeeOTMProgram.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeOTMProgram.Department;
import com.EmployeeOTMProgram.Employee;
import com.EmployeeOTMProgram.Repo.EmpRepo;
import com.EmployeeOTMProgram.RequestDTO.EmployeeDTO;
import com.EmployeeOTMProgram.ResponseDTO.BaseResponse;
import com.EmployeeOTMProgram.Service.EmpService;

@RestController
@RequestMapping(value = "/app",produces = "application/json")
public class EmployeeController {

	@Autowired
	EmpService empService;
	
	@Autowired
	EmpRepo repo;
	
	@GetMapping("/getEmployees")
	public List<Employee>getAllEmployees()
	{
		List<Employee> emp=empService.getAllEmployees();
		return emp;
	}
	
	@PostMapping("/employee")
	public ResponseEntity<BaseResponse> saveEmployee(@RequestBody EmployeeDTO employee)
	{
		try {
		BaseResponse res=new BaseResponse();
		res=empService.addEmployee(employee,res);

		res.setResCode(200);
		res.setResMsg("Employee saved");
		
		return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		//return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
		
		
	}
	@GetMapping("/departments")
	@ResponseBody
	public List<Department> viewDepartments()
	{
		List<Department> d=empService.viewAll();
		return d;
	}
	
	@GetMapping("/byid")
	@ResponseBody
	public Employee findByid(@RequestParam("id")Integer id)
	{
		
		Employee emp=empService.findUserById(id);
		return emp;
		//Optional<Employee> op=repo.findById(id);
		//System.out.println(op);
	//	return repo.findById(id);
		
	}
}
