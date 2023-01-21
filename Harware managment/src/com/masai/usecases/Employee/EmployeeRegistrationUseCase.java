package com.masai.usecases.Employee;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.dao.HODDao;
import com.masai.dao.HODDaoImpl;
import com.masai.model.Employee;
import com.masai.model.HOD;

public class EmployeeRegistrationUseCase {
	
	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in)){
			
			
			
			System.out.println("Enter Employee Name :");
			String EmpName=sc.next();
			
			System.out.println("Enter Employee Email: ");
			String EmpEmail=sc.next();
			
			System.out.println("Enter Employee Password :");
			String EmpPass=sc.next();
			
			
			
			Employee emp = new Employee();
		
			emp.setEmpName(EmpName);
			emp.setEmpEmail(EmpEmail);
			emp.setEmpPass(EmpPass);
			
			
			EmployeeDao dao= new EmployeeDaoImpl();
			
			String result;
			
			try {
				
				result =  dao.EmployeeRegistration(emp);
				
				System.out.println(result);
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
			
			
		}
	}
	

}
