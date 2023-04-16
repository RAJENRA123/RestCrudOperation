package com.BikkadIT.RestApiCrudOperation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.RestApiCrudOperation.dao.EmployeeRepository;
import com.BikkadIT.RestApiCrudOperation.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public boolean saveEmployee(Employee emp) {
	Employee employee = employeeRepository.save(emp);
	
		if(employee != null) {
			return true;
		}else{
		return false;
	}

	}
	@Override
	public boolean saveAllEmployee(List<Employee> list) {
		List<Employee> saveAll = employeeRepository.saveAll(list);
		
		if(saveAll != null ) {
		return true;
	}
		return false;
		
	}
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> findAll = employeeRepository.findAll();
		
		return findAll;
	}
	@Override
	public Employee getSingleEmployeeQueryParam(int empId) {
	Employee findById = employeeRepository.findById(empId).get();
		return findById;
	}
	@Override
	public Employee getSingleEmployeePathParam(int empId) {
		Employee findById = employeeRepository.findById(empId).get();
		return findById;
	}
	@Override
	public Employee getSingleEmployeeByReqBody(Employee emp) {
		int empId=emp.getEmpId();
		Employee emp1 = employeeRepository.findById(empId).get();
		return emp1;
	}
	@Override
	public boolean updateEmployee(Employee emp) {
		boolean existsById = employeeRepository.existsById(emp.getEmpId());
		if(existsById) {
			Employee employee = employeeRepository.save(emp);
			return true;
			
		}
		return false;
	}
	@Override
	public boolean deleteById(int empid) {
	boolean existsById = employeeRepository.existsById(empid);
	if(existsById) {
		employeeRepository.deleteById(empid);
		return true;
	}
		return false;
	}
	@Override
	public boolean deleteAllEmployee() {
		List<Employee> findAll = employeeRepository.findAll();
		if(findAll !=null) {
	employeeRepository.deleteAll();
	return true;
		}else{
	return false;
	}
}}