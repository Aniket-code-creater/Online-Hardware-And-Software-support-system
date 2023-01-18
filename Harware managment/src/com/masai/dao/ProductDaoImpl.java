package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.exception.SoftwareException;
import com.masai.model.Product;
import com.masai.utility.DBUtility;

public class ProductDaoImpl implements ProductDao{

	@Override
	public String insertProductDetails(int ProductId, String ProductName, int ProductQuantity, String ProductDesc,
			String ProductCategory) {
		// TODO Auto-generated method stub
		
		

		String message = "Not Inserted";
		
		
		try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("insert into Products values(?,?,?,?,?)");
			
			ps.setInt(1, ProductId);
			ps.setString(2, ProductName);
			ps.setInt(3, ProductQuantity);
			ps.setString(4, ProductDesc);
			ps.setString(5, ProductCategory);
			
			int x =ps.executeUpdate();
			
			if(x>0) {
				message="Record Inserted Syccessfully";
			}
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			message=e.getMessage();;
			
		}
		
		return message;
	}

	@Override
	public String insertProductDetails1(Product product) throws SoftwareException {
		
	String message = "Not Inserted";
		
		
		try(Connection conn= DBUtility.providconnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("insert into Products values(?,?,?,?,?)");
			
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setInt(3, product.getProductQuantity());
			ps.setString(4, product.getProductDesc());
			ps.setString(5, product.getProcductCategory());
			
		
			
			int x =ps.executeUpdate();
			
			if(x>0) {
				message="Record Inserted Syccessfully";
			}
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SoftwareException(e.getMessage());
			
			
			
		}
		
		return message;
		
		
	}

	
	

}
