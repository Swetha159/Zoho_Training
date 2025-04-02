package com.zoho.training.jdbc.task;

public class EmployeeRelation {

	private int employee_id,age;
	private String name , relationship;
	public String getName() {
		return name;
	}
	
	public EmployeeRelation(int employee_id, String name, int age, String relationship)
	{
		this.age=age;
		this.employee_id=employee_id;
		this.name=name;
		this.relationship = relationship;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
