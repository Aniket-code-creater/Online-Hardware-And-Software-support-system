package com.masai.usecases.Hod;

import java.util.Scanner;

import com.masai.dao.HODDao;
import com.masai.dao.HODDaoImpl;
import com.masai.model.Engineer;

public class InsertEngineerUseCase {

	
	
	public static void main(String[] aargs) {
try(Scanner sc= new Scanner(System.in)){
			
			System.out.println("Enter Engineer Id: ");
			int EngId=sc.nextInt();
			
			System.out.println("Enter Engineer Name :");
			String EngUserName=sc.next();
			
			System.out.println("Enter Engineer Email: ");
			String EngEmail=sc.next();
			
			System.out.println("Enter Engineer Password :");
			String EngPass=sc.next();
			
			System.out.println("Enter Engineer Category: ");
			String EngCategory=sc.next();
			
			System.out.println("Enter HODId" );
			int HODId=sc.nextInt();
			
			
		
			
			Engineer eng= new Engineer();
			eng.setEngId(EngId);
			eng.setEngName(EngUserName);
			eng.setEngEmail(EngEmail);
			eng.setEngPass(EngPass);
			eng.setEngCategory(EngCategory);
//			eng.setEngAssignProblem(EngAssignProblem);
			eng.setHODId(HODId);;;
			
		
			
			
			
			HODDao dao=new HODDaoImpl();
			
			String result;
			
			try {
				
				result =  dao.insertEngineer(eng);
				
				System.out.println(result);
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
			
			
		}
	}
}
