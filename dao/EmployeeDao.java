package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Employee;

public class EmployeeDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String dbURL = "jdbc:oracle:thin:@10.101.121.236:1521:xe";
	private String dbUserName = "batch0518";
	private String dbPassword = "batch0518";
	private Connection con = null;
	
	public int deleteEmployee(int employeeId) {
		int numOfEmployeesDeleted = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
			PreparedStatement pat = con.prepareStatement("DELETE TBL_1579349_EMPLOYEE WHERE EMPLOYEE_ID=?");
			pat.setInt(1, employeeId);
			numOfEmployeesDeleted = pat.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return numOfEmployeesDeleted;
		
	}
	
	public int updateEmployee(Employee employee) {
		int numOfEmployeesUpdated = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
			PreparedStatement pat = 
				con.prepareStatement(
					"UPDATE TBL_1579349_EMPLOYEE SET EMPLOYEE_NAME=?,GENDER=?,DESIGNATION=?,EMAIL=? WHERE EMPLOYEE_ID=?");
			
			pat.setString(1,  employee.getEmployeeName());
			pat.setString(2, employee.getGender());
			pat.setString(3, employee.getDesignation());
			pat.setString(4,  employee.getEmail());
			pat.setInt(5, employee.getEmployeeId());
			numOfEmployeesUpdated = pat.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return numOfEmployeesUpdated;
	}
	
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> empList = new ArrayList<>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
			PreparedStatement pat = con.prepareStatement("select * from TBL_1579349_EMPLOYEE");
			ResultSet rs = pat.executeQuery();
			
			while (rs.next()) {
				Employee e = new Employee();
				int empId = rs.getInt("EMPLOYEE_ID");
				String empName = rs.getString("EMPLOYEE_NAME");
				String gender = rs.getString("GENDER");
				String designation = rs.getString("DESIGNATION");
				String email = rs.getString("EMAIL");
				e.setEmployeeId(empId);
				e.setEmployeeName(empName);
				e.setDesignation(designation);
				e.setGender(gender);
				e.setEmail(email);
				empList.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return empList;
	}
	
	public int addEmployee(Employee employee) {
		int numOfEmployeesAdded = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
			PreparedStatement pat = con.prepareStatement("insert into TBL_1579349_EMPLOYEE values (?,?,?,?,?)");
			
			pat.setInt(1, employee.getEmployeeId());
			pat.setString(2,  employee.getEmployeeName());
			pat.setString(3, employee.getGender());
			pat.setString(4, employee.getDesignation());
			pat.setString(5,  employee.getEmail());
			numOfEmployeesAdded = pat.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return numOfEmployeesAdded;
	}
}
