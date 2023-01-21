package com.masai.usecases.Employee;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

import com.masai.exception.EmployeeExceptions;
import com.masai.model.Complain;


public class GetComplainHistoryUseCase {
	public static void main(String[] args) {
		
		try(Scanner sc= new Scanner(System.in)){
		

		
		System.out.println("Enter Your Id To See Your All raised Complain Histry: ");
		int EmpId=sc.nextInt();
		
		EmployeeDao dao=new EmployeeDaoImpl();
		
		
		
		
			List<Complain> Eng= dao.ComplainHistoryByEmpId(EmpId);
			
			Eng.forEach(s->{
				
				System.out.println("Complain Id is :"+s.getComplainId());
				System.out.println("Complain :"+s.getRaise_complain());
				System.out.println("Employee Id :"+s.getEmpId());
				System.out.println("Engineer Id :"+s.getEngId());
				System.out.println("Engineer Name :"+s.getEngineer_name());
				
				System.out.println("Engineer HOD id :"+s.getHODId());
				System.out.println("========================================================================");
				
				
			});
		}catch(EmployeeExceptions e) {
			System.out.println(e.getMessage());
		}
		
	}

}
