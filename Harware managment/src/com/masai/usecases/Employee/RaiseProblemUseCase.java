package com.masai.usecases.Employee;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;


public class RaiseProblemUseCase {
public static void main(String[] args) {
		
		try(Scanner sc= new Scanner(System.in)){
		

		
		System.out.println("Enter Your Id: ");
		int EmpId=sc.nextInt();
		
		System.out.println("Enter Your Complain: ");
		String Raise_Problem=sc.next();
		
		
		EmployeeDao dao=new EmployeeDaoImpl();
		
			
			String result;
			
			try {
				
				result =  dao.registerCoplainByEmpId(EmpId, Raise_Problem);
				
				System.out.println(result);
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
		
		}
	}

}
