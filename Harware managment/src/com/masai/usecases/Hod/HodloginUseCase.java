package com.masai.usecases.Hod;

import java.util.Scanner;

import com.masai.dao.HODDao;
import com.masai.dao.HODDaoImpl;
import com.masai.model.HOD;

public class HodloginUseCase {
	
	public static void main(String[] args) {
		
		try(Scanner sc= new Scanner(System.in)){
				
				System.out.println("Enter Hod Email: ");
				String HodEmail=sc.next();
				
				System.out.println("Enter Hod Password :");
				int HodPass=sc.nextInt();
			
				HODDao Dao=new HODDaoImpl();
			
				try {
					HOD hod = Dao.loginHod(HodEmail, HodPass);
					System.out.println("Welcome "+hod.getHODName());
			
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					
				}
				
				
			}
		}

}
