package com.masai.usecases.Engineer;

import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;

public class ChangeEngPassByEngIdUseCase {
public static void main(String[] args) {
		
		try(Scanner sc= new Scanner(System.in)){
		

		
		System.out.println("Enter Engineer Id: ");
		int EngId=sc.nextInt();
		
		System.out.println("Enter New Password : ");
		String EngPass=sc.next();
		
		
		EngineerDao dao=new EngineerDaoImpl();
		
			
			String result;
			
			try {
				
				result =  dao.ChangeEngineerPassByEngId(EngId, EngPass);
				
				System.out.println(result);
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
		
		}
	}

}
