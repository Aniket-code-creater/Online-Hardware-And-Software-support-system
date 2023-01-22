package com.masai.usecases.Hod;

import java.util.Scanner;

import com.masai.dao.HODDao;
import com.masai.dao.HODDaoImpl;

public class AssignEngineerTOEmpComplainUseCase {
	
	
	public static void main(String[] aargs) {
		try(Scanner sc= new Scanner(System.in)){
					
					System.out.println("Enter Engineer Id: ");
					int EngId=sc.nextInt();
					
					System.out.println("HOD Id");
					int HODId=sc.nextInt();
					System.out.println("Enter Engineer name :");
					String Engineername=sc.next();
					
					System.out.println("Complain Id");
					int ComoplainId=sc.nextInt();
					
					

					
					HODDao dao=new HODDaoImpl();
					
					String result;
					
					try {
						
						result =  dao.AssignEngineerToEmployeeComplain(EngId, Engineername, HODId, ComoplainId);
						
						System.out.println(result);
						
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
						
					}
					
					
				}
			}

}
