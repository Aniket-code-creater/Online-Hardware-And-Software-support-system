package com.masai.usecases.Employee;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

import com.masai.model.Employee;


public class EmployeeloginUseCase {
	public static void main(String[] args) {
		
		try(Scanner sc= new Scanner(System.in)){
				
				System.out.println("Enter  Email: ");
				String EmpEmail=sc.next();
				
				System.out.println("Enter Password :");
				String EmpPass=sc.next();
			
				EmployeeDao Dao=new EmployeeDaoImpl();
			
				try {
					Employee emp = Dao.Employeelogin(EmpEmail, EmpPass);
					System.out.println("Welcome "+emp.getEmpName());
			
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					
				}
				
				
			}
		}


}
