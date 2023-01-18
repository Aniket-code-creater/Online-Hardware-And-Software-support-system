package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImpl;
import com.masai.exception.SoftwareException;

public class InsertProductUseCase  {
	public static void main(String[] args) {
		
		try(Scanner sc= new Scanner(System.in)){
			
			System.out.println("Enter Product Id: ");
			int ProductId=sc.nextInt();
			
			System.out.println("Enter Product Name :");
			String ProductName=sc.next();
			
			System.out.println("Enter Product Quantity: ");
			int ProductQuanitity=sc.nextInt();
			
			System.out.println("Enter Product Description :");
			String ProductDesc=sc.next();
			
			
			System.out.println("Enter Product Category :");
			String ProductCategory=sc.next();
			
			
			ProductDao dao=new ProductDaoImpl();
			
			String result;
			
			try {
				
				result = dao.insertProductDetails(ProductId, ProductName, ProductQuanitity, ProductDesc, ProductCategory);
				
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			
			
			
			
			
		}
		
	}

}
