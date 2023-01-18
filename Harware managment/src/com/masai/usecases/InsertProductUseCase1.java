package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImpl;
import com.masai.exception.SoftwareException;
import com.masai.model.Product;

public class InsertProductUseCase1{
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
			
			Product product = new Product(ProductId,ProductName,ProductQuanitity,ProductDesc,ProductCategory);
			
			
			ProductDao dao=new ProductDaoImpl();
			
			String result;
			
			try {
				
				result =  dao.insertProductDetails1(product);
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
			
			
			
			
		}
		
	}

}
