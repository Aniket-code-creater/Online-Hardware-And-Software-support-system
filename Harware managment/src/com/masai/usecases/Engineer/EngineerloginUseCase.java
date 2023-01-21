package com.masai.usecases.Engineer;

import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.model.Engineer;

public class EngineerloginUseCase {
public static void main(String[] args) {
		
		try(Scanner sc= new Scanner(System.in)){
				
				System.out.println("Enter Email: ");
				String EngEmail=sc.next();
				
				System.out.println("Enter Password :");
				String EngPass=sc.next();
		
				EngineerDao Dao= new EngineerDaoImpl();
			
				try {

					Engineer eng=Dao.loginEngineer(EngEmail, EngPass);
					System.out.println("Welcome "+eng.getEngName());
					
			
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					
				}
				
				
			}
		}

}
