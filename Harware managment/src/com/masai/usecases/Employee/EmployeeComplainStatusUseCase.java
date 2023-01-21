package com.masai.usecases.Employee;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

import com.masai.model.Complain;


public class EmployeeComplainStatusUseCase {
	
public static void main(String[] args) {
		
		try(Scanner sc= new Scanner(System.in)){
		

		
		System.out.println("Enter Your Id : ");
		int EmpId=sc.nextInt();
		
		EmployeeDao dao=new EmployeeDaoImpl();
		
			
		Complain comp= new Complain();
			
			try {
				
				comp =  dao.EmployeeViewComplainStatusByEmpId(EmpId);
				
				if(comp.getEngId()==0) {
					System.out.println("Engineer is not Assign to you ");
				}else {
					System.out.println("Your Engineer id is :"+comp.getEngId());
					System.out.println("Your Engineer name is :"+comp.getEngineer_name());
					System.out.println("Your Coplain is :"+comp.getRaise_complain());
				}
				
//				System.out.println("Assigned Problem is :"+eng.getEngAssignProblem());
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
		
		}
	}

}
