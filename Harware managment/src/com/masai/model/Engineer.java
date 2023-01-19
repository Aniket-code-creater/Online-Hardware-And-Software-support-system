package com.masai.model;

public class Engineer {
	
//	int EngId, String EngName, String EngEmail, int EngPass,String EngCategory,String EngProblem,String EngAssignProblem,String ProblemStatus
	
	private int EngId;
	private String EngName;
	private String EngEmail;
	private String EngPass;
	private String EngCategory;
	private String EngProblem;
	private String EngAssignProblem;
	private String ProblemStatus;
	private int HODId;
	
	public Engineer(){
		
	}

	public Engineer(int engId, String engName, String engEmail, String engPass, String engCategory, String engProblem,
			String engAssignProblem, String problemStatus, int hODId) {
		super();
		EngId = engId;
		EngName = engName;
		EngEmail = engEmail;
		EngPass = engPass;
		EngCategory = engCategory;
		EngProblem = engProblem;
		EngAssignProblem = engAssignProblem;
		ProblemStatus = problemStatus;
		HODId = hODId;
	}

	public int getEngId() {
		return EngId;
	}

	public void setEngId(int engId) {
		EngId = engId;
	}

	public String getEngName() {
		return EngName;
	}

	public void setEngName(String engName) {
		EngName = engName;
	}

	public String getEngEmail() {
		return EngEmail;
	}

	public void setEngEmail(String engEmail) {
		EngEmail = engEmail;
	}

	public String getEngPass() {
		return EngPass;
	}

	public void setEngPass(String engPass) {
		EngPass = engPass;
	}

	public String getEngCategory() {
		return EngCategory;
	}

	public void setEngCategory(String engCategory) {
		EngCategory = engCategory;
	}

	public String getEngProblem() {
		return EngProblem;
	}

	public void setEngProblem(String engProblem) {
		EngProblem = engProblem;
	}

	public String getEngAssignProblem() {
		return EngAssignProblem;
	}

	public void setEngAssignProblem(String engAssignProblem) {
		EngAssignProblem = engAssignProblem;
	}

	public String getProblemStatus() {
		return ProblemStatus;
	}

	public void setProblemStatus(String problemStatus) {
		ProblemStatus = problemStatus;
	}

	public int getHODId() {
		return HODId;
	}

	public void setHODId(int hODId) {
		HODId = hODId;
	}

	@Override
	public String toString() {
		return "Engineer [EngId=" + EngId + ", EngName=" + EngName + ", EngEmail=" + EngEmail + ", EngPass=" + EngPass
				+ ", EngCategory=" + EngCategory + ", EngProblem=" + EngProblem + ", EngAssignProblem="
				+ EngAssignProblem + ", ProblemStatus=" + ProblemStatus + ", HODId=" + HODId + "]";
	}

	
	
	
	

}
