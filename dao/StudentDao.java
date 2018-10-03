package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Employee;
import bean.Student;

public class StudentDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String dbURL = "jdbc:oracle:thin:@10.101.121.236:1521:xe";
	private String dbUserName = "batch0518";
	private String dbPassword = "batch0518";
	private Connection con = null;
	
	public int deleteStudent(int studentId) {
		int numOfStudentsDeleted = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
			PreparedStatement pat = con.prepareStatement("DELETE TBL_1579349_STUDENT WHERE STUDENT_ID=?");
			pat.setInt(1, studentId);
			numOfStudentsDeleted = pat.executeUpdate();
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
		return numOfStudentsDeleted;
		
	}
	
	public int updateStudent(Student student) {
		int numOfStudentsUpdated = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
			PreparedStatement pat = 
				con.prepareStatement(
					"update TBL_1579349_STUDENT set STUDENT_NAME=?,GENDER=?,ADDRESS=?,COURSE_NAME=? where STUDENT_ID=?");
			
			pat.setString(1, student.getStudentName());
			pat.setString(2, student.getGender());
			pat.setString(3, student.getAddress());
			pat.setString(4, student.getCourseName());
			pat.setInt(5, student.getStudentId());
			numOfStudentsUpdated = pat.executeUpdate();
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
		return numOfStudentsUpdated;
	}
	
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> studentList = new ArrayList<>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
			PreparedStatement pat = con.prepareStatement("select * from TBL_1579349_STUDENT");
			ResultSet rs = pat.executeQuery();
			
			while (rs.next()) {
				Student s = new Student();
				int studentId = rs.getInt("STUDENT_ID");
				String studentName = rs.getString("STUDENT_NAME");
				String gender = rs.getString("GENDER");
				String address = rs.getString("ADDRESS");
				String courseName = rs.getString("COURSE_NAME");
				s.setStudentId(studentId);
				s.setGender(gender);
				s.setStudentName(studentName);
				s.setAddress(address);
				s.setCourseName(courseName);
				studentList.add(s);
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
		return studentList;
	}
	
	public int addStudent(Student student) {
		int numOfStudentAdded = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
			PreparedStatement pat = con.prepareStatement("insert into TBL_1579349_STUDENT values (?,?,?,?,?)");
			pat.setInt(1, student.getStudentId());
			pat.setString(2, student.getStudentName());
			pat.setString(3, student.getGender());
			pat.setString(4, student.getAddress());
			pat.setString(5, student.getCourseName());
			numOfStudentAdded = pat.executeUpdate();
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
		return numOfStudentAdded;
	}
}
