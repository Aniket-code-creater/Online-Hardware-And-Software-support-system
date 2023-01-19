package com.masai.usecases;

import java.util.List;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImpl;
import com.masai.exception.SoftwareException;
import com.masai.model.Product;

public class GetAllProductUseCase {
	public static void main(String[] args) {
		
		ProductDao dao= new ProductDaoImpl();
		
		try {
			List<Product> products = dao.getAllProductDetails();
			
			products.forEach(s->{
			
				System.out.println("Product Id :"+s.getProductId());
				System.out.println("Product name :"+s.getProductName());
				System.out.println("product Quantity :"+s.getProductQuantity());
				System.out.println("Product description :"+s.getProductDesc());
				System.out.println("Product Category :"+s.getProcductCategory());
				
				System.out.println("=================================================================");
				
			});
			
			
		} catch (SoftwareException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
