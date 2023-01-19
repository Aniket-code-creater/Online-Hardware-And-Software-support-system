package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImpl;
import com.masai.exception.SoftwareException;
import com.masai.model.Product;

public class GetProductUseCase {
	public static void main(String[] args) {
		

		try(Scanner sc= new Scanner(System.in)){
			
			System.out.println("Enter Product Id: ");
			int ProductId=sc.nextInt();
			
			ProductDao dao= new ProductDaoImpl();
			
			try {
				Product product = dao.getProductDetailById(ProductId);
//				System.out.println(product);
				System.out.println("Product Id :"+product.getProductId());
				System.out.println("Product name :"+product.getProductName());
				System.out.println("product Quantity :"+product.getProductQuantity());
				System.out.println("Product description :"+product.getProductDesc());
				System.out.println("Product Category :"+product.getProcductCategory());
				
			} catch (SoftwareException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			
			
			
			
			
			
			
		}
	}

}
