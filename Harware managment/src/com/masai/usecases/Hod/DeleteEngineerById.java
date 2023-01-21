package com.masai.usecases.Hod;

import java.util.Scanner;

import com.masai.dao.HODDao;
import com.masai.dao.HODDaoImpl;

public class DeleteEngineerById {
	public static void main(String[] args) {
		
		try(Scanner sc= new Scanner(System.in)){
		

		
		System.out.println("Enter Engineer Id: ");
		int EngId=sc.nextInt();
		System.out.println("Are You sure you want to delete this Engineer data y/n");
		String o=sc.next();
		
		HODDao dao=new HODDaoImpl();
		if(o.equals("y")) {
			
			String result;
			
			try {
				
				result =  dao.deleteEngineerByEngId(EngId);
				
				System.out.println(result);
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
			
		}
		else {
			System.out.println("ThanYou For Your Response");
		}
	
	}
}

}
