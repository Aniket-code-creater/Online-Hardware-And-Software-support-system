package com.masai.dao;

import java.util.List;

import com.masai.exception.EngineerExceptions;
import com.masai.model.Complain;
import com.masai.model.Engineer;

public interface EngineerDao {
	
	//Engineer login
	public Engineer loginEngineer(String EngEmail,String EngPass) throws EngineerExceptions;
	
	//show Engineer Assign Problem
	public Engineer GetEngineerAssignProblemByEngId(int EngId) throws EngineerExceptions;
	
	
	//for update engineer problem status pending or done or not started etc;
	public String updateEngineerProblemStatusbyEngId(int EngId, String EngAssignProblemStatus) throws EngineerExceptions;
	
	//method for change the engineer password
	public String ChangeEngineerPassByEngId(int EngId, String EngPass) throws EngineerExceptions;
	
	public List<Complain> AttendComplainHistoryByEngId(int EngId) throws EngineerExceptions;

}
