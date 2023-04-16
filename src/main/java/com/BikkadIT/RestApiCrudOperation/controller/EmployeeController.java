package com.BikkadIT.RestApiCrudOperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.RestApiCrudOperation.model.Employee;
import com.BikkadIT.RestApiCrudOperation.service.EmployeeServiceI;

import net.bytebuddy.description.type.RecordComponentList;


@RestController
public class EmployeeController {
    
	@Autowired
	private EmployeeServiceI employeeServiceI;
	
	@PostMapping(value="saveEmployee", consumes="application/json")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp){
		
		boolean saveEmployee = employeeServiceI.saveEmployee(emp);
		if(saveEmployee) {
			
			String msg="Employee Saved Successful";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}else {
			 
			String msg="Employee not Saved";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}}
	@PostMapping(value="saveAllEmployee", consumes="application/json")
	public ResponseEntity<String> saveAllEmployee(@RequestBody List<Employee>list) {
		
		
		 boolean saveAllEmployee = employeeServiceI.saveAllEmployee(list);
		 
		
		if(saveAllEmployee) {
			return new ResponseEntity<String>("All Employee save Successfully", HttpStatus.OK);
					
		
		}
		return new ResponseEntity<String>("All Employeee not saved Successfully", HttpStatus.BAD_REQUEST);
}
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		List<Employee> allEmployee = employeeServiceI.getAllEmployee();
		
		return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
		
	}
	@GetMapping(value="/getEmpByIdQueryParam",produces="application/json")
	public ResponseEntity<Employee> getByIdQueryParam(@RequestParam int empId){
		Employee emp = employeeServiceI.getSingleEmployeeQueryParam(empId);
		
			
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}		
		 
	
	@GetMapping(value="/getEmpByIdPathParam/{empId}",produces="application/json")
	public ResponseEntity<Employee> getByIdPathParam(@PathVariable int empId){
		Employee emp = employeeServiceI.getSingleEmployeePathParam(empId);
		
			
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
}
	@GetMapping(value="/getByIdReqBody",produces="application/json")
	public ResponseEntity<Employee> getByIdReqBody(@RequestBody Employee emp){
		Employee emp1 = employeeServiceI.getSingleEmployeeByReqBody(emp);
		
			
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
}
	@PutMapping(value="updateEmployee",consumes="application/json")
	public ResponseEntity<String>updateEmployee(@RequestBody Employee emp){
		boolean updateEmployee = employeeServiceI.updateEmployee(emp);
		
		if(updateEmployee) {
			return new ResponseEntity<String>("Employee update successfull",HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Employee not update successfully",HttpStatus.BAD_REQUEST);
		
		
	}
	@DeleteMapping(value="/deleteById/{empid}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int empid){
		boolean deleteById = employeeServiceI.deleteById(empid);
		if(deleteById) {
			return new ResponseEntity<String>("Employee delete successful",HttpStatus.OK);
			}
		return new ResponseEntity<String>("Employee not delete successfully",HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/deleteAllEmplyee")
public ResponseEntity deleteAllEmployee(){
	
	boolean deleteAllEmployee = employeeServiceI.deleteAllEmployee();
	
	if(deleteAllEmployee) {
		return new ResponseEntity("Employee deleted successfull",HttpStatus.OK);
		
	}
	
	return new ResponseEntity("Employee not deleted successfully",HttpStatus.BAD_REQUEST);
	
	
		
	}
}