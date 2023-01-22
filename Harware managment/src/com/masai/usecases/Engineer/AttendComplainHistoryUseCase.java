package com.masai.usecases.Engineer;

import java.util.List;
import java.util.Scanner;


import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;

import com.masai.exception.EngineerExceptions;
import com.masai.model.Complain;

public class AttendComplainHistoryUseCase {
	

public static void main(String[] args) throws EngineerExceptions {
		
		try(Scanner sc= new Scanner(System.in)){
		

		
		System.out.println("Enter Your Id To See Your All Attend Complain Histry: ");
		int EngId=sc.nextInt();
		
		EngineerDao dao=new EngineerDaoImpl();
		
		
		
		
			List<Complain> Eng= dao.AttendComplainHistoryByEngId(EngId);
			if(Eng.isEmpty()) {
				System.out.println("No Any Complain History found ");
			}else {
				Eng.forEach(s->{
					
					System.out.println("Complain Id is :"+s.getComplainId());
					System.out.println("Complain :"+s.getRaise_complain());
					System.out.println("Employee Id :"+s.getEmpId());

					System.out.println("========================================================================");
					
				
				
				
			});
				
			}
			
			
		}catch(EngineerExceptions e) {
			System.out.println(e.getMessage());
		}
		
	}

}
