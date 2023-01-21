package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.HodExceptions;
import com.masai.model.Engineer;
import com.masai.model.HOD;
import com.masai.utility.DBUtility;

public class HODDaoImpl implements HODDao{

	
	
	
	
	//insert the HOD data TO the table HOD
	@Override
	public String insertHod(HOD hod) throws HodExceptions {
		// TODO Auto-generated method stub
		
       String message = "Not Inserted";
		
		
		try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("insert into HOD values(?,?,?,?)");
			
			ps.setInt(1, hod.getHODId());
			ps.setString(2, hod.getHODName());
			ps.setString(3, hod.getHODEmail());
			ps.setInt(4, hod.getHODPass());
			
			int x =ps.executeUpdate();
			
			if(x>0) {
				message="inserted Successfully";
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new HodExceptions(e.getMessage());	
		}
		
		return message;
	
	}

	
	//HOD Login logic.................................................................................................................................
	@Override
	public HOD loginHod(String HODEmail, int HODPass) throws HodExceptions {
		
		HOD hod= null;
		try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("Select * from hod where HODEmail=? AND HODPass=? ");
			
			ps.setString(1, HODEmail);
			ps.setInt(2, HODPass);
			
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				hod=new HOD();
				
				hod.setHODId(rs.getInt("HODId"));
				hod.setHODName(rs.getString("HODName"));
				hod.setHODEmail(rs.getString("HODEmail"));
				hod.setHODPass(rs.getInt("HODPass"));
			}else {
				throw new HodExceptions("Invalid HOd Password and Email");
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new HodExceptions(e.getMessage());	
		}
		
		
		return hod;
	}

	
	
	//register Engineer code logic............................................................................................................
	@Override
	public String insertEngineer(Engineer engineer) throws HodExceptions {
		
		
		 String message = "Not Inserted";
			
			
			try(Connection conn= DBUtility.providconnection()){
				
				
				PreparedStatement ps = conn.prepareStatement("insert into Engineer(EngId,EngUserName, EngEmail, EngPass, EngCategory,HODId) values(?,?,?,?,?,?)");
				
				ps.setInt(1, engineer.getEngId());
				ps.setString(2, engineer.getEngName());
				ps.setString(3, engineer.getEngEmail());
				ps.setString(4, engineer.getEngPass());
				ps.setString(5, engineer.getEngCategory());
				ps.setInt(6, engineer.getHODId());
				
//				ps.setString(6, engineer.getEngAssignProblem());
				
				
				
				
				
				int x =ps.executeUpdate();
				
				if(x>0) {
					message="Engineer Register Successfully";
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new HodExceptions(e.getMessage());	
			}
			
			return message;
	}

	
	//....logic for to get the all Engineer Details ............................................................................................ 
	@Override
	public List<Engineer> getAllEngineerDetails() throws HodExceptions {
		
		List<Engineer> eng=new ArrayList<>();
		
		try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("select * from Engineer");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("EngId");
				String n=rs.getString("EngUserName");
				String e=rs.getString("EngEmail");
				String p=rs.getString("EngPass");
				String c= rs.getString("EngCategory");
				String pr=rs.getString("EngProblem");
				String pra=rs.getString("EngAssignProblem");
				String s=rs.getString("EngProblestatus");
				int Hid=rs.getInt("HODId");
				
				
				
				Engineer Eng=new Engineer(id,n,e,p,c,pr,pra,s,Hid);
				
				eng.add(Eng);
			}
			if(eng.isEmpty()) {
				throw new HodExceptions("No Engineer Found");
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new HodExceptions(e.getMessage());	
		}
		
		
		
		return eng;
	}

//code for delete a engineer by engineer id.................................................................................................
	@Override
	public String deleteEngineerByEngId(int EngId) throws HodExceptions {
		
		 String message = "Not Deleted";
			
			
			try(Connection conn= DBUtility.providconnection()){
				
				
				PreparedStatement ps = conn.prepareStatement("delete from Engineer where EngID=?");
				
				ps.setInt(1, EngId);
				
				
				int x =ps.executeUpdate();
				
				if(x>0) {
					message="Deleted Successfully";
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new HodExceptions(e.getMessage());	
			}
			
			return message;
		
	}


	@Override
	public List<Engineer> AllRaisedProblem() throws HodExceptions {
		
		
List<Engineer> eng=new ArrayList<>();
		
		try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("select EngProblem from Engineer");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int id=rs.getInt("EngId");
				String n=rs.getString("EngUserName");
//				String e=rs.getString("EngEmail");
//				String p=rs.getString("EngPass");
//				String c= rs.getString("EngCategory");
				String pr=rs.getString("EngProblem");
				
				
				Engineer Eng=new Engineer();
				Eng.setEngProblem(pr);
				Eng.setEngId(id);
				Eng.setEngName(n);
				
				eng.add(Eng);
			}
			if(eng.isEmpty()) {
				throw new HodExceptions("No Engineer Found");
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new HodExceptions(e.getMessage());	
		}
		
		
		
		return eng;
	}


	@Override
	public String AssignProblemToEngineerbyEngId(String EngAssignProblem, int EngId, int HODId) throws HodExceptions {
		
		
		
		 String message = "Not Assign";
			
			
			try(Connection conn= DBUtility.providconnection()){
				
				
				PreparedStatement ps = conn.prepareStatement("update Engineer set EngAssignProblem=? where EngID=? AND HODId=?");
				
				
				ps.setInt(2, EngId);
				ps.setInt(3, HODId);
				ps.setString(1, EngAssignProblem);
				
				
				
				int x =ps.executeUpdate();
				
				if(x>0) {
					message="Problem Assign to the Engineer Successfully";
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new HodExceptions(e.getMessage());	
			}
			
			return message;
	}


	


	



}

























