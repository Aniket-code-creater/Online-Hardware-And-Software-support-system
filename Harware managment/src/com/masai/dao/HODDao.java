package com.masai.dao;

import java.util.List;

import com.masai.exception.HodExceptions;
import com.masai.model.Engineer;
import com.masai.model.HOD;

public interface HODDao {
	
//	int EngId, String EngName, String EngEmail, int EngPass,String EngCategory,String EngProblem,String EngAssignProblem,String ProblemStatus
	
	public String insertHod(HOD hod) throws HodExceptions;
	
	public HOD loginHod(String HODEmail,int HODPass)throws HodExceptions;
	
	public String insertEngineer(Engineer engineer)throws HodExceptions;
	
	public List<Engineer> getAllEngineerDetails()throws HodExceptions;
	
	
	public String deleteEngineerByEngId(int EngId) throws HodExceptions;
	
	public List<Engineer> AllRaisedProblem() throws HodExceptions;
	
	public String AssignProblemToEngineerbyEngId( String EngAssignProblem,int EngId,int HODId) throws HodExceptions;
	
	

}
