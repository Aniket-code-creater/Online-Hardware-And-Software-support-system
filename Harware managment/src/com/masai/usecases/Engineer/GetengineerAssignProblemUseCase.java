package com.masai.usecases.Engineer;

import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.model.Engineer;

public class GetengineerAssignProblemUseCase {
public static void main(String[] args) {
		
		try(Scanner sc= new Scanner(System.in)){
		

		
		System.out.println("Enter Engineer Id: ");
		int EngId=sc.nextInt();
		
		EngineerDao dao=new EngineerDaoImpl();
		
			
		Engineer eng= new Engineer();
			
			try {
				
				eng =  dao.GetEngineerAssignProblemByEngId(EngId);
				
				System.out.println("Assigned Problem is :"+eng.getEngAssignProblem());
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
		
		}
	}

}
