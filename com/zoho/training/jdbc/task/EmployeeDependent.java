package com.zoho.training.jdbc.task;

public class EmployeeDependent {
	private int employeeID;
	private String employeeName;
	private int relationID;
	private String relationName;
	private int relationAge;
	private String relationship;

	public EmployeeDependent(int employeeID, String employeeName, int relationID, String relationName, int relationAge,
			String relationship) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.relationID = relationID;
		this.relationName = relationName;
		this.relationAge = relationAge;
		this.relationship = relationship;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public int getrelationID() {
		return relationID;
	}

	public String getrelationName() {
		return relationName;
	}

	public int getrelationAge() {
		return relationAge;
	}

	public String getRelationship() { return relationship; }
}
