package com.masai.model;

public class Employee {
	
	private int EmpId;
	private String EmpName;
	private String EmpEmail;
	private String EmpPass;
	
	public Employee() {
		
	}

	public Employee(int empId, String empName, String empEmail, String empPass) {
		super();
		EmpId = empId;
		EmpName = empName;
		EmpEmail = empEmail;
		EmpPass = empPass;
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getEmpEmail() {
		return EmpEmail;
	}

	public void setEmpEmail(String empEmail) {
		EmpEmail = empEmail;
	}

	public String getEmpPass() {
		return EmpPass;
	}

	public void setEmpPass(String empPass) {
		EmpPass = empPass;
	}

	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", EmpEmail=" + EmpEmail + ", EmpPass=" + EmpPass
				+ "]";
	}

	
}
