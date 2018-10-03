import bean.Student;
import dao.StudentDao;

public class TestStudentDao {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		Student s = new Student();
		
//		s.setStudentId(1);
//		s.setStudentName("Mike");
//		s.setGender("Male");
//		s.setAddress("123 Street, Texas");
//		s.setCourseName("Computer Science");
//		studentDao.addStudent(s);
		
		studentDao = new StudentDao();
		s = new Student();
		s.setStudentId(1);
		s.setStudentName("Amerita Singh");
		s.setGender("Female");
		int numOfStuUpdated = studentDao.updateStudent(s);
		System.out.println("Number of Students Updated: " + numOfStuUpdated);
	}
}
