package com.zoho.training.jdbc.task;

import com.zoho.training.exceptions.TaskException;
import com.zoho.training.utility.Util;

public class JdbcTask {
	
	public Employee getEmployee(String name , String mobile, String email,String department) throws TaskException
	{
		Util.validateInput(name , "Name");
		Util.validateInput(email,"email");
		Util.validateInput(mobile,"mobile");
		Util.validateInput(department,"department");
		return new Employee(name,mobile,email,department);
	}

	public EmployeeRelation getEmployeeRelation(String name , int age, String relationship,int id) throws TaskException
	{
		Util.validateInput(name , "Name");
		Util.validateInput(age,"age");
		Util.validateInput(relationship,"relationship");
		Util.validateInput(id,"id");
		return new EmployeeRelation(id,name,age,relationship);
	}
	

}
