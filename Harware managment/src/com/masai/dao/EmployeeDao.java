package com.masai.dao;

import java.util.List;

import com.masai.exception.EmployeeExceptions;
import com.masai.model.Complain;
import com.masai.model.Employee;

public interface EmployeeDao {
	
	public String EmployeeRegistration(Employee empl) throws EmployeeExceptions;
	
	public Employee Employeelogin(String EmpEmail, String EmpPass) throws EmployeeExceptions;
	
	public String ChangeEmployeePasswordByEmpId(int EmpId, String EmpPass ) throws EmployeeExceptions;
	
	public String registerCoplainByEmpId(int EmpId, String EmpComplain) throws EmployeeExceptions;
	
	public List<Complain> ComplainHistoryByEmpId(int EmpId) throws EmployeeExceptions;
	
	public Complain EmployeeViewComplainStatusByEmpId(int EmpId) throws EmployeeExceptions;
	
}
