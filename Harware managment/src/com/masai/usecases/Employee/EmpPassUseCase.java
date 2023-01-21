package com.masai.usecases.Employee;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;


public class EmpPassUseCase {
	
public static void main(String[] args) {
		
		try(Scanner sc= new Scanner(System.in)){
		

		
		System.out.println("Enter Employee Id: ");
		int EmpId=sc.nextInt();
		
		System.out.println("Enter New Password : ");
		String EmpPass=sc.next();
		
		
		EmployeeDao dao=new EmployeeDaoImpl();
		
			
			String result;
			
			try {
				
				result =  dao.ChangeEmployeePasswordByEmpId(EmpId, EmpPass);
				
				System.out.println(result);
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
		
		}
	}

}
