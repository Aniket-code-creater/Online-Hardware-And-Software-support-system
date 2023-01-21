package com.masai.usecases.Hod;

import java.util.Scanner;

import com.masai.dao.HODDao;
import com.masai.dao.HODDaoImpl;
import com.masai.model.HOD;

public class InsertHodUseCase {
	
	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in)){
			
			System.out.println("Enter HOD Id: ");
			int HodId=sc.nextInt();
			
			System.out.println("Enter Hod Name :");
			String HodName=sc.next();
			
			System.out.println("Enter Hod Email: ");
			String HodEmail=sc.next();
			
			System.out.println("Enter Hod Password :");
			int HodPass=sc.nextInt();
			
			
			
			HOD hod = new HOD(HodId,HodName,HodEmail,HodPass);
			
			
			HODDao dao=new HODDaoImpl();
			
			String result;
			
			try {
				
				result =  dao.insertHod(hod);
				
				System.out.println(result);
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
			
			
		}
	}

}
