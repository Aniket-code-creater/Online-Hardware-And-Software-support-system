package com.masai.model;

public class HOD {
	
	private int HODId;
	private String HODName;
	private String HODEmail;
	private int HODPass;
	
	public HOD() {
		
	}

	public HOD(int hODId, String hODName, String hODEmail, int hODPass) {
		super();
		HODId = hODId;
		HODName = hODName;
		HODEmail = hODEmail;
		HODPass = hODPass;
	}

	public int getHODId() {
		return HODId;
	}

	public void setHODId(int hODId) {
		HODId = hODId;
	}

	public String getHODName() {
		return HODName;
	}

	public void setHODName(String hODName) {
		HODName = hODName;
	}

	public String getHODEmail() {
		return HODEmail;
	}

	public void setHODEmail(String hODEmail) {
		HODEmail = hODEmail;
	}

	public int getHODPass() {
		return HODPass;
	}

	public void setHODPass(int hODPass) {
		HODPass = hODPass;
	}

	@Override
	public String toString() {
		return "HOD [HODId=" + HODId + ", HODName=" + HODName + ", HODEmail=" + HODEmail + ", HODPass=" + HODPass + "]";
	}
	
	

}
