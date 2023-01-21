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
import com.masai.model.Employee;
import com.masai.model.Engineer;
import com.masai.utility.DBUtility;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String EmployeeRegistration(Employee empl) throws EmployeeExceptions {
		
		
		String message="Not register";
		
try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("insert into Employee(EmpName, EmpEmail, EmpPass) values(?,?,?)");
			
//			ps.setInt(1, empl.getEmpId());
			ps.setString(1, empl.getEmpName());
			ps.setString(2, empl.getEmpEmail());
			ps.setString(3, empl.getEmpPass());
			
			int x =ps.executeUpdate();
			
			if(x>0) {
				message="Register Successfully";
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EmployeeExceptions(e.getMessage());	
		}
		
		
		
		return message;
	}

	//method for login employee using employee email and Employee password....................................................
	@Override
	public Employee Employeelogin(String EmpEmail, String EmpPass) throws EmployeeExceptions {
		
		
		
		
		Employee emp= null;
		try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("Select * from employee where EmpEmail=? AND EmpPass=? ");
			
			ps.setString(1, EmpEmail);
			ps.setString(2, EmpPass);
			
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				emp=new Employee();
				
				emp.setEmpId(rs.getInt("EmpId"));
				emp.setEmpName(rs.getString("EmpName"));
				emp.setEmpEmail(rs.getString("EmpEmail"));
				emp.setEmpPass(rs.getString("EmpPass"));
			}else {
				throw new EmployeeExceptions("Invalid Employee Password and Email");
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EmployeeExceptions(e.getMessage());	
		}
		
		
		return emp;
	}

	
	//method for change employee account password using Employee id..............................................................
	@Override
	public String ChangeEmployeePasswordByEmpId(int EmpId, String EmpPass) throws EmployeeExceptions {
	
		
		String message = "Password Not Changed";
		
		
		try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("update Employee set EmpPass=? where EmpId=?");
			
			ps.setInt(2, EmpId);
			ps.setString(1, EmpPass);
			
			
			int x =ps.executeUpdate();
			
			if(x>0) {
				message="PassWord Updated Successfully";
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EmployeeExceptions(e.getMessage());	
		}
		
		return message;
	}

	
	//method for raise any complain using Employee id.......................................................................
	@Override
	public String registerCoplainByEmpId(int EmpId, String EmpComplain) throws EmployeeExceptions {
		
		

		 String message = "Complain Not Register";
			
			
			try(Connection conn= DBUtility.providconnection()){
				
				
				PreparedStatement ps = conn.prepareStatement("update Complain set raise_complain=? where EmpId=?");
				
				ps.setInt(2, EmpId);
				ps.setString(1, EmpComplain);
				
				
				int x =ps.executeUpdate();
				
				if(x>0) {
					message="Complain Raised Successfully";
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new EmployeeExceptions(e.getMessage());	
			}
			
			return message;
	}
	
	
//Method for view  all Complain History by employee id.............................................................................
	@Override
	public List<Complain> ComplainHistoryByEmpId(int EmpId) throws EmployeeExceptions {
		
		List<Complain> comp=new ArrayList<>();
		
		try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("select * from Complain where EmpId=?");
			ps.setInt(1, EmpId);
			
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
				throw new EmployeeExceptions("No complain Found");
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EmployeeExceptions(e.getMessage());	
		}
		
		
		
		return comp;
	}

	
	
	@Override
	public Complain EmployeeViewComplainStatusByEmpId(int EmpId) throws EmployeeExceptions {
		
		Complain comp= null;
		try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("Select * from Complain where EmpId=? ");
			
			ps.setInt(1, EmpId);
			
			
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				comp=new Complain();
				
				comp.setComplainId(rs.getInt("complainId"));
				comp.setRaise_complain(rs.getString("raise_complain"));
				comp.setEmpId(rs.getInt("EmpId"));
				comp.setEngId(rs.getInt("EngId"));
				comp.setEngineer_name(rs.getString("Engineer_name"));
				
				
	
			}else {
				throw new EmployeeExceptions("Complain not found ");
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EmployeeExceptions(e.getMessage());	
		}
		
		
		return comp;
	}
	
	

}
