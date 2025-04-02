package com.zoho.training.jdbc.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset.Type;
import com.zoho.training.exceptions.TaskException;

public class EmployeeDAO {

	public void addEmployeeInfo(Employee[] employeeArray, int count) throws TaskException {

		String insertQuery = "INSERT INTO EmployeeInfo (name,  mobile, email,department) " + "VALUES (?, ?, ?, ?)";
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			for (int i = 0; i < count; i++) {
				Employee employee = employeeArray[i];
				statement.setString(1, employee.getName());
				statement.setString(2, employee.getMobile());
				statement.setString(3, employee.getEmail());
				statement.setString(4, employee.getDepartment());
				statement.addBatch();
			}
			statement.executeBatch();

		} catch (SQLException e) {
			throw new TaskException(e.getMessage(), e);
		}
	}

	public boolean createEmployeeInfo() throws TaskException {

		try (Connection connection = DBConnection.getConnection();
				Statement statement = connection.createStatement();) {
			String createQuery = "CREATE TABLE EmployeeInfo "
					+ "(id INT AUTO_INCREMENT PRIMARY KEY, name  VARCHAR(50) NOT NULL, "
					+ "mobile  VARCHAR(20) NOT NULL UNIQUE ," + " email  VARCHAR(50) NOT NULL UNIQUE,"
					+ " department  VARCHAR(50) NOT NULL);";
			statement.executeUpdate(createQuery);
			return true;
		} catch (SQLException e) {
			throw new TaskException(e.getMessage(), e);

		}

	}

	public List<Employee> displayEmployee(String name) throws TaskException {

		String query = "SELECT * FROM EmployeeInfo WHERE name=?";
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, name);
			try (ResultSet rs = statement.executeQuery()) {

				while (rs.next()) {
					Employee employee = new Employee();
					employee.setId(rs.getInt("id"));
					employee.setName(rs.getString("name"));
					employee.setMobile(rs.getString("mobile"));
					employee.setEmail(rs.getString("email"));
					employee.setDepartment(rs.getString("department"));
					employeeList.add(employee);
				}
			}
		} catch (SQLException e) {
			throw new TaskException(e.getMessage(), e);
		}
		return employeeList;
	}

	public int updateDepartment(int id, String department) throws TaskException {
		return updateColumn(id, department, "department");
	}

	public int updateEmail(int id, String email) throws TaskException {
		return updateColumn(id, email, "email");
	}

	public int updateMobile(int id, String mobile) throws TaskException {
		return updateColumn(id, mobile, "mobile");
	}

	private int updateColumn(int id, String value, String columnName) throws TaskException {

		int rowsUpdated = 0;
		String updateQuery = "UPDATE EmployeeInfo SET " + columnName + "=? WHERE id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			statement.setString(1, value);
			statement.setInt(2, id);

			rowsUpdated = statement.executeUpdate();
			
			

		} catch (SQLException e) {
			throw new TaskException(e.getMessage(), e);
		}

		return rowsUpdated;
	}



	public List<Employee> getRecords(int n, boolean flag) throws TaskException {
		String order = "DESC";
		if (flag) {
			order = "ASC";
		}
		return getRecordsSorted(n, order);
	}

	private List<Employee> getRecordsSorted(int n, String order) throws TaskException {
		String query = "SELECT * FROM EmployeeInfo  ORDER BY name " + order + " LIMIT ?";
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, n);
			try (ResultSet rs = statement.executeQuery();) {
//				ResultSetMetaData meta = rs.getMetaData();
//				int colCount = meta.getColumnCount();
//				while(rs.next())
//				{
//					Employee employee = new Employee();
//					
//				for (int i = 1; i <= colCount; i++) {
//					
//					String colName = meta.getColumnName(i);
//					int colType = meta.getColumnType(i);
//					if (colType == Types.INTEGER) {
//						setEmployee(rs.getInt(colName), employee);
//					} else {
//						setEmployee(colName, rs.getString(colName), employee);
//					}
//					}
//				employeeList.add(employee);
//				}
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setMobile(rs.getString("mobile"));
				employee.setEmail(rs.getString("email"));
				employee.setDepartment(rs.getString("department"));
				employeeList.add(employee);
			}
			}
		} catch (

		SQLException e) {
			throw new TaskException(e.getMessage(), e);
		}
		return employeeList;
	}

//	private void setEmployee(int value, Employee employee) {
//
//		employee.setId(value);
//
//	}
//
//	private void setEmployee(String colName, String value, Employee employee) {
//
//		switch (colName) {
//		case "name":
//			employee.setName(value);
//			break;
//		case "mobile":
//			employee.setMobile(value);
//			break;
//		case "email":
//			employee.setEmail(value);
//			break;
//		case "department":
//			employee.setDepartment(value);
//			break;
//		}
//
//	}

	public int delete(int id) throws TaskException {
		String deleteQuery = "DELETE FROM EmployeeInfo WHERE id=?";
		int rowsDeleted = 0;

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(deleteQuery);) {
			statement.setInt(1, id);
			rowsDeleted = statement.executeUpdate();

		} catch (SQLException e) {
			throw new TaskException(e.getMessage(), e);
		}
		return rowsDeleted;

	}

	public boolean createEmployeeRelation() throws TaskException {
		try (Connection connection = DBConnection.getConnection();
				Statement statement = connection.createStatement();) {
			String createQuery = "CREATE TABLE EmployeeRelationInfo " + "(relationID INT AUTO_INCREMENT PRIMARY KEY,"
					+ "relatioName VARCHAR(50) NOT NULL," + "relationAge INT NOT NULL,"
					+ "relationship VARCHAR(50) NOT NULL,"
					+ "employee_id INT,FOREIGN KEY (employee_id) REFERENCES EmployeeInfo(id));";

			statement.executeUpdate(createQuery);
			return true;
		} catch (SQLException e) {
			throw new TaskException(e.getMessage(), e);
		}

	}

	public int insertRelation(EmployeeRelation relation) throws TaskException {
		int rowsAffected = 0;
		String insertQuery = "INSERT INTO EmployeeRelationInfo (relationName,  relationAge, relationship,employee_id) "
				+ "VALUES (?, ?, ?, ?)";
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			statement.setString(1, relation.getName());
			statement.setInt(2, relation.getAge());
			statement.setString(3, relation.getRelationship());
			statement.setInt(4, relation.getEmployee_id());

			rowsAffected = statement.executeUpdate();
		} catch (SQLException e) {
			throw new TaskException(e.getMessage(), e);
		}
		return rowsAffected;

	}

	public List<EmployeeDependent> getEmployeeRelation(int id, String name) throws TaskException {

		String query = "SELECT e.id," + "e.name ," + "r.relationID," + "r.relationName," + "r.relationAge,"
				+ "r.relationship" + " FROM EmployeeInfo e" + " JOIN EmployeeRelationInfo r "
				+ "ON e.id = r.employee_id" + " WHERE e.id = ? OR e.name = ?;";

		List<EmployeeDependent> employeeDependentList = new ArrayList<>();

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, id);
			statement.setString(2, name);
			try (ResultSet rs = statement.executeQuery()) {

				while (rs.next()) {
					EmployeeDependent employeeDependent = new EmployeeDependent(rs.getInt("id"), rs.getString("name"),
							rs.getInt("relationID"), rs.getString("relationName"), rs.getInt("relationAge"),
							rs.getString("relationship"));
					employeeDependentList.add(employeeDependent);
				}
			}

		} catch (SQLException e) {
			throw new TaskException(e.getMessage(), e);
		}
		return employeeDependentList;
	}

	public List<EmployeeDependent> getEmployeeRelationRecords(int n) throws TaskException {
		String query = "SELECT e.id," + "e.name ," + "r.relationID," + "r.relationName," + "r.relationAge,"
				+ "r.relationship" + " FROM EmployeeInfo e" + " JOIN EmployeeRelationInfo r "
				+ "ON e.id = r.employee_id  ORDER BY name  LIMIT ?";
		List<EmployeeDependent> employeeDependentList = new ArrayList<EmployeeDependent>();
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, n);
			try (ResultSet rs = statement.executeQuery()) {

				while (rs.next()) {
					EmployeeDependent employeeDependent = new EmployeeDependent(rs.getInt("id"), rs.getString("name"),
							rs.getInt("relationID"), rs.getString("relationName"), rs.getInt("relationAge"),
							rs.getString("relationship"));
					employeeDependentList.add(employeeDependent);

				}
			}

		} catch (SQLException e) {
			throw new TaskException(e.getMessage(), e);
		}
		return employeeDependentList;
	}

}