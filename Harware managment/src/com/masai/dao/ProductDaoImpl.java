package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				message="Product Added Successfully";
			}
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SoftwareException(e.getMessage());
			
			
			
		}
		
		return message;
		
		
	}

	@Override
	public Product getProductDetailById(int ProductId) throws SoftwareException {
		
	
		Product product=null;
		
		try(Connection conn= DBUtility.providconnection()){
			
			//query to get the Product details by product id;
			PreparedStatement ps = conn.prepareStatement("select * from Products where ProductId=?");
			
			ps.setInt(1, ProductId);
			
			
		
			
			ResultSet rs =ps.executeQuery();
			
			if(rs.next()) {
				int i=rs.getInt("ProductId");
				String n=rs.getString("ProductName");
				
				int q=rs.getInt("ProductQuantity");
				String d=rs.getString("ProductDesc");
				String ql=rs.getString("ProductCategory");
				
				//mapping the result set the Product been class object;
				
				product= new Product();
				
				product.setProductId(i);
				product.setProductName(n);
				product.setProductQuantity(q);
				product.setProductDesc(d);
				product.setProcductCategory(ql);
			}
			else {
				throw new SoftwareException("Product does not exits with This Product Id :"+ ProductId);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SoftwareException(e.getMessage());
			
		}
		
		
		
		return product;
	}

	@Override
	public List<Product> getAllProductDetails() throws SoftwareException {
		
		
		List<Product> products = new ArrayList<>();
		
		
try(Connection conn= DBUtility.providconnection()){
			
			//query to get the Product details by product id;
			PreparedStatement ps = conn.prepareStatement("select * from Products");
			
			
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				int i=rs.getInt("ProductId");
				String n=rs.getString("ProductName");
				
				int q=rs.getInt("ProductQuantity");
				String d=rs.getString("ProductDesc");
				String ql=rs.getString("ProductCategory");
				
				Product product = new Product(i,n,q,d,ql);
				products.add(product);
				
				
			}
			if(products.isEmpty()) {
				throw new SoftwareException("No Product found");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SoftwareException(e.getMessage());
			
		}
		
		
		
		return products;
		
	}

	
	

}
