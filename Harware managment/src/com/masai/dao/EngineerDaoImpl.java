package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.EmployeeExceptions;
import com.masai.exception.EngineerExceptions;
import com.masai.exception.HodExceptions;
import com.masai.model.Complain;
import com.masai.model.Engineer;
import com.masai.utility.DBUtility;

public class EngineerDaoImpl implements EngineerDao{

	@Override
	public Engineer loginEngineer(String EngEmail, String EngPass) throws EngineerExceptions {
		
		
		Engineer eng= null;
		try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("Select * from Engineer where EngEmail=? AND EngPass=? ");
			
			ps.setString(1, EngEmail);
			ps.setString(2, EngPass);
			
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				eng=new Engineer();
				
				eng.setHODId(rs.getInt("EngId"));
				eng.setEngName(rs.getString("EngUserName"));
				eng.setEngEmail(rs.getString("EngEmail"));
				eng.setEngPass(rs.getString("EngPass"));
				eng.setEngCategory(rs.getString("EngCategory"));
				eng.setEngAssignProblem(rs.getString("EngAssignProblem"));
				eng.setEngProblem(rs.getString("EngProblem"));
				eng.setProblemStatus(rs.getString("EngProblestatus"));
				eng.setHODId(rs.getInt("HODId"));
			}else {
				throw new EngineerExceptions("Invalid Engineer Password or Email");
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EngineerExceptions(e.getMessage());	
		}
		
		
		return eng;
	}

	
//	code for Engineer can view the problem assigned to him by HOD ........................................................................................
	@Override
	public Engineer GetEngineerAssignProblemByEngId(int EngId) throws EngineerExceptions {
		
		Engineer eng= null;
		try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("Select * from Engineer where EngId=? ");
			
			ps.setInt(1, EngId);
			
			
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				eng=new Engineer();
				
				eng.setHODId(rs.getInt("EngId"));
				eng.setEngName(rs.getString("EngUserName"));
				eng.setEngEmail(rs.getString("EngEmail"));
				eng.setEngPass(rs.getString("EngPass"));
				eng.setEngCategory(rs.getString("EngCategory"));
				eng.setEngAssignProblem(rs.getString("EngAssignProblem"));
				eng.setEngProblem(rs.getString("EngProblem"));
				eng.setProblemStatus(rs.getString("EngProblestatus"));
				eng.setHODId(rs.getInt("HODId"));
			}else {
				throw new EngineerExceptions("Engineer not found with id "+eng.getEngId());
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EngineerExceptions(e.getMessage());	
		}
		
		
		return eng;
	}


	@Override
	public String updateEngineerProblemStatusbyEngId(int EngId,String EngAssignProblemStatus) throws EngineerExceptions {


		 String message = "Problem Status Not Updated";
			
			
			try(Connection conn= DBUtility.providconnection()){
				
				
				PreparedStatement ps = conn.prepareStatement("update engineer set EngProblestatus=? where EngId=?");
				
				ps.setInt(2, EngId);
				ps.setString(1, EngAssignProblemStatus);
				
				
				int x =ps.executeUpdate();
				
				if(x>0) {
					message="Problem Status Updated Successfully";
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new EngineerExceptions(e.getMessage());	
			}
			
			return message;
		
		
	}


	@Override
	public String ChangeEngineerPassByEngId(int EngId, String EngPass) throws EngineerExceptions {
		
		

		 String message = "Password Not Changed";
			
			
			try(Connection conn= DBUtility.providconnection()){
				
				
				PreparedStatement ps = conn.prepareStatement("update engineer set EngPass=? where EngId=?");
				
				ps.setInt(2, EngId);
				ps.setString(1, EngPass);
				
				
				int x =ps.executeUpdate();
				
				if(x>0) {
					message="PassWord Updated Successfully";
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new EngineerExceptions(e.getMessage());	
			}
			
			return message;
	}


	@Override
	public List<Complain> AttendComplainHistoryByEngId(int EngId) throws EngineerExceptions {
		
		
List<Complain> comp=new ArrayList<>();
		
		try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("select * from Complain where EngId=?");
			ps.setInt(1, EngId);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("complainId");
				String c=rs.getString("raise_complain");
				int e=rs.getInt("EmpId");
				String en=rs.getString("Engineer_name");
				int eId=rs.getInt("EngId");
				
				
				int Hid=rs.getInt("HODId");
				
				
				
				Complain Eng=new Complain();
				Eng.setComplainId(id);
				Eng.setRaise_complain(c);
				Eng.setEmpId(e);
				Eng.setEngineer_name(en);
				Eng.setEngId(eId);
				Eng.setHODId(Hid);
				
				comp.add(Eng);
			}
			if(comp.isEmpty()) {
				throw new EngineerExceptions("No complain History Found");
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EngineerExceptions(e.getMessage());	
		}
		
		
		
		return comp;
	}

}
