package com.zoho.training.jdbc.runner;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.zoho.training.exceptions.TaskException;
import com.zoho.training.jdbc.task.Employee;
import com.zoho.training.jdbc.task.EmployeeDAO;
import com.zoho.training.jdbc.task.EmployeeDependent;
import com.zoho.training.jdbc.task.EmployeeRelation;
import com.zoho.training.jdbc.task.JdbcTask;

public class JdbcRunner {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		JdbcRunner runner = new JdbcRunner();
		EmployeeDAO dao = new EmployeeDAO();
		JdbcTask task = new JdbcTask();
		try {
			int choice = 0;
			while (choice != 14) {
			try {
				
					System.out.println("1.Create Employee Table" 
							+ "\n2.Insert Records in Employee Table"
							+ "\n3.Find record by name"
							+ "\n4.Update Department" 
							+ "\n5.Update Email"
							+ "\n6.Update Mobilenumber" 
							+ "\n7.Print N rows of Employee"
							+ "\n8.Print N rows of Employee by ascending or descending order(name)"
							+ "\n9.Delete Record by id"
							+ "\n10.Create EmployeeRelation Table" 
							+ "\n11.Insert records in EmployeeRelation"
							+ "\n12.Find relation by Id"
							+ "\n13.Print N rows of EmployeeRelation by ascending order(name)"
							+ "\nEnter your choice :");
					choice = scan.nextInt();
					scan.nextLine();
					switch (choice) {
					case 1:
						if(dao.createEmployeeInfo())
						{
						System.out.println("Employee Table Created");
						}
						else {
							System.out.println("Error occured in table creation");
						}
						break;
					case 2:
						System.out.println("Enter the no.of records:");
						int count = scan.nextInt();
						scan.nextLine();
						Employee[] employeeArray = new Employee[count];
						for(int i=0;i<count;i++)
						{
						System.out.println("Enter details of the Employee");
						System.out.println("Enter Name :");
						String name = scan.nextLine();
						System.out.println("Enter Mobile Number :");
						String mobile = scan.nextLine();
						System.out.println("Enter Email :");
						String email = scan.nextLine();
						System.out.println("Enter Department:");
						String department = scan.nextLine();
						Employee employee = task.getEmployee(name, email, mobile, department);
						employeeArray[i] = employee;
						}
						dao.addEmployeeInfo(employeeArray,count);
						System.out.println("Employee Data Inserted ");
						break;
					case 3:
						System.out.println("Enter the name to find :");
						String value = scan.nextLine();
						List<Employee> employeeList = dao.displayEmployee(value);
						if (employeeList == null || employeeList.isEmpty()) {
							System.out.println("Error Occured .Try Again");
						}
						else
						{
							System.out.println("Name Not Found");
						}
						runner.printResult(employeeList);
						break;
					case 4:
						System.out.println("Enter the id :");
						int id = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter the Department :");
						String department = scan.nextLine();
						int rowsUpdated = dao.updateDepartment(id, department);
						if (rowsUpdated > 0) {
							System.out.println("Employee Department Updated ");
						} else {
							System.out.println("Employee Department Not Updated ");
						}
						break;
					case 5:
						System.out.println("Enter the id :");
						id = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter the Email :");
						String email = scan.nextLine();
						rowsUpdated = dao.updateEmail(id, email);
						if (rowsUpdated > 0) {
							System.out.println("Employee Email Updated ");
						} else {
							System.out.println("Employee Email Not Updated ");
						}
						break;
					case 6:
						System.out.println("Enter the id :");
						id = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter the MobileNumber :");
						String mobile = scan.nextLine();
						rowsUpdated = dao.updateMobile(id, mobile);
						if (rowsUpdated > 0) {
							System.out.println("Employee MobileNumber Updated ");
						} else {
							System.out.println("Employee MobileNumber Not Updated ");
						}
						break;
					case 7:
						System.out.println("Enter the N value :");
						int n = scan.nextInt();
						employeeList = dao.getRecords(n,true);
						if (employeeList == null || employeeList.isEmpty()) {
							System.out.println("Error Occured .Try Again");
						}
						else
						{
							runner.printResult(employeeList);
						}
						
						break;

					case 8:
						boolean order;
						System.out.println("Enter the N value :");
						n = scan.nextInt();
						System.out.println("For ascending ,Enter 1\nFor descening ,Enter 2:");
						if(scan.nextInt()==1) {
							order =true;
						}
						else
						{
							order = false;
						}
						employeeList = dao.getRecords(n,order);
						if (employeeList == null || employeeList.isEmpty()) {
							System.out.println("Error Occured .Try Again");
						}
						else
						{
							System.out.println("No data present");
						}
						runner.printResult(employeeList);
						break;
					case 9:
						System.out.println("Enter the Id :");
						id = scan.nextInt();
						int rowsDeleted = dao.delete(id);
						if (rowsDeleted > 0) {
							System.out.println("Record Deleted ");
						} else {
							System.out.println("Error Occured Try again  ");
						}
						break;
					case 10:
						if(dao.createEmployeeRelation())
						{
							System.out.println("EmployeeRelation Table Created");
						}
						else {
							System.out.println("Error occured in table creation");
						}
						break;
					case 11:
						System.out.println("Enter details of the Employee Relation");
						System.out.println("Enter Employee ID:");
						int employeeId = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter Name :");
						String name = scan.nextLine();
						System.out.println("Enter Age :");
						int age = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter Relationship :");
						String relationship = scan.nextLine();

						EmployeeRelation relation =task.getEmployeeRelation( name, age, relationship,employeeId);
						int rowsAffected = dao.insertRelation(relation);
						if (rowsAffected > 0) {
							System.out.println("EmployeeRelation Data Inserted ");
						} else {
							System.out.println("Error Inserting Data .Try Again");
						}
						break;
					case 12:
						System.out.println("Enter the id to find :");
						id = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter the Employee Name :");
						name = scan.nextLine();
						List<EmployeeDependent> employeeDependentList = dao.getEmployeeRelation(id, name);
						if (employeeDependentList == null || employeeDependentList.isEmpty()) {
							System.out.println("Error Occured .Try Again");
						}
						runner.printTable(employeeDependentList);
						break;
					case 13:
						System.out.println("Enter the N value :");
						n = scan.nextInt();
						employeeDependentList = dao.getEmployeeRelationRecords(n);
						if (employeeDependentList == null || employeeDependentList.isEmpty()) {
							System.out.println("Error Occured .Try Again");
						}
						runner.printTable(employeeDependentList);
						break;
					case 14 : 
						System.out.println("Exiting");
						break;
					default:
						System.out.println("Invalid Choice");
					}
				

			}catch(InputMismatchException e)
			{
				System.out.println("Invalid input");
                scan.nextLine(); 
			} catch (TaskException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		} finally {
			scan.close();
		}

	}

	public void printResult(List<Employee> employeeList) {
		System.out.printf("%-5s %-15s %-25s %-15s %-15s%n", "ID", "Name", "Email", "Mobile", "Department");
		System.out.println("------------------------------------------------------------------------------");

		for (Employee employee : employeeList) {
			System.out.printf("%-5d %-15s %-25s %-15s %-15s%n", employee.getId(), employee.getName(),
					employee.getEmail(), employee.getMobile(), employee.getDepartment());
		}
	}

	public void printTable(List<EmployeeDependent> employeeDependentList) {
	    System.out.printf( "%-12s %-20s %-12s %-20s %-12s %-15s%n", 
	                      "EmployeeID", "EmployeeName", "RelationID", "RelationName", "RelationAge","Relationship");
	    System.out.println("------------------------------------------------------------------------------");

	    for (EmployeeDependent employee : employeeDependentList) {
	        System.out.printf( "%-12s %-20s %-12s %-20s %-12s %-15s%n", 
	                          employee.getEmployeeID(),
	                          employee.getEmployeeName(),
	                          employee.getrelationID(),
	                          employee.getrelationName(),
	                          employee.getrelationAge(),
	                          employee.getRelationship());
	    }
	}

}
