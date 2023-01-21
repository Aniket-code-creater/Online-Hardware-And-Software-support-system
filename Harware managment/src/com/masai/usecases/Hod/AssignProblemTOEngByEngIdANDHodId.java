package com.masai.usecases.Hod;

import java.util.Scanner;

import com.masai.dao.HODDao;
import com.masai.dao.HODDaoImpl;

public class AssignProblemTOEngByEngIdANDHodId {
	
	public static void main(String[] aargs) {
		try(Scanner sc= new Scanner(System.in)){
					
					System.out.println("Enter Engineer Id: ");
					int EngId=sc.nextInt();
					
					System.out.println("HOD Id");
					int HODId=sc.nextInt();
					System.out.println("Enter Assign Proble to Engineer :");
					String problem=sc.next();
					

					
					HODDao dao=new HODDaoImpl();
					
					String result;
					
					try {
						
						result =  dao.AssignProblemToEngineerbyEngId(problem, EngId, HODId);
						
						System.out.println(result);
						
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
						
					}
					
					
				}
			}

}
