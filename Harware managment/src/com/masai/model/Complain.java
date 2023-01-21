package com.masai.model;

public class Complain {
	
	private int complainId;
	private String raise_complain;
	private String Engineer_name;
	private int EmpId;
	private int EngId;
	private int HODId;
	
	public Complain() {
		
	}

	public Complain(int complainId, String raise_complain, String engineer_name, int empId, int engId, int hODId) {
		super();
		this.complainId = complainId;
		this.raise_complain = raise_complain;
		Engineer_name = engineer_name;
		EmpId = empId;
		EngId = engId;
		HODId = hODId;
	}

	public int getComplainId() {
		return complainId;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}

	public String getRaise_complain() {
		return raise_complain;
	}

	public void setRaise_complain(String raise_complain) {
		this.raise_complain = raise_complain;
	}

	public String getEngineer_name() {
		return Engineer_name;
	}

	public void setEngineer_name(String engineer_name) {
		Engineer_name = engineer_name;
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public int getEngId() {
		return EngId;
	}

	public void setEngId(int engId) {
		EngId = engId;
	}

	public int getHODId() {
		return HODId;
	}

	public void setHODId(int hODId) {
		HODId = hODId;
	}

	@Override
	public String toString() {
		return "Complain [complainId=" + complainId + ", raise_complain=" + raise_complain + ", Engineer_name="
				+ Engineer_name + ", EmpId=" + EmpId + ", EngId=" + EngId + ", HODId=" + HODId + "]";
	}
	
	

}
