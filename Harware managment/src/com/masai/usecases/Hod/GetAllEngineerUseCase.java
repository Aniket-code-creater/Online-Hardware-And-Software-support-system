package com.masai.usecases.Hod;

import java.util.List;

import com.masai.dao.HODDao;
import com.masai.dao.HODDaoImpl;
import com.masai.exception.HodExceptions;
import com.masai.model.Engineer;

public class GetAllEngineerUseCase {
	
public static void main(String[] args) {
		
		HODDao Dao=new HODDaoImpl();
		
		try {
			List<Engineer> Eng= Dao.getAllEngineerDetails();
			
			Eng.forEach(s->{
				
				System.out.println("Engineer Id is :"+s.getEngId());
				System.out.println("Engineer Name is :"+s.getEngName());
				System.out.println("Engineer Email is :"+s.getEngEmail());
				System.out.println("Engineer Password is :"+s.getEngPass());
				System.out.println("Engineer Category is :"+s.getEngCategory());
				System.out.println("Engineer Have Problem :"+s.getEngProblem());
				System.out.println("Engineer Assign Problem is :"+s.getEngAssignProblem());
				System.out.println("Engineer  Problem Status is :"+s.getProblemStatus());
				System.out.println("Engineer HOD id is"+s.getHODId());
				System.out.println("========================================================================");
				
				
			});
		}catch(HodExceptions e) {
			System.out.println(e.getMessage());
		}
		
	}

}
