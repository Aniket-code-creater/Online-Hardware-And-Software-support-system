package com.masai.model;

public class Product {
	
	private int ProductId;
	private String ProductName;
	private int ProductQuantity;
	private String ProductDesc;
	private String ProcductCategory;
	
	public Product() {
		
	}

	public Product(int productId, String productName, int productQuantity, String productDesc,
			String procductCategory) {
		super();
		ProductId = productId;
		ProductName = productName;
		ProductQuantity = productQuantity;
		ProductDesc = productDesc;
		ProcductCategory = procductCategory;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}

	public String getProductDesc() {
		return ProductDesc;
	}

	public void setProductDesc(String productDesc) {
		ProductDesc = productDesc;
	}

	public String getProcductCategory() {
		return ProcductCategory;
	}

	public void setProcductCategory(String procductCategory) {
		ProcductCategory = procductCategory;
	}

	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", ProductQuantity="
				+ ProductQuantity + ", ProductDesc=" + ProductDesc + ", ProcductCategory=" + ProcductCategory + "]";
	}
	
	
	
}
