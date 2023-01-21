package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.masai.exception.EngineerExceptions;
import com.masai.exception.HodExceptions;
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

}
