package com.zoho.training.jdbc.task;

public class Employee {
	
	private int id;
	private String name , mobile , department, email;
	
	public Employee(String name ,String email, String mobile ,String department)
	{
		this.name = name;
		this.department = department;
		this.mobile = mobile;
		this.email = email;
	}
	public Employee()
	{
		
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString()
	{
		return "Id :"+id+"\nName:"+name+"\nMobile Number :"+ mobile +"\nEmail : "+email + "\nDepartment :"+department;
		
	}
	
	
}
