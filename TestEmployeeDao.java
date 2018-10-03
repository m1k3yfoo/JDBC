import bean.Employee;
import dao.EmployeeDao;

public class TestEmployeeDao {

	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDao();
		Employee e = new Employee();
		e.setEmployeeId(1579349);
		e.setEmployeeName("Mike");
		e.setGender("Male");
		e.setDesignation("Associate");
		e.setEmail("email@tcs.com");
		employeeDao.addEmployee(e);
		
//		employeeDao = new EmployeeDao();
//		ArrayList<Employee> empList = employeeDao.getAllEmployees();
//		
//		for (Employee e : empList) {
//			System.out.println("ID: " + e.getEmployeeId());
//			System.out.println("Name: " + e.getEmployeeName());
//			System.out.println("Gender: " + e.getGender());
//			System.out.println("Designation: " + e.getDesignation());
//			System.out.println("Email: " + e.getEmail());
//		}
		
//		employeeDao = new EmployeeDao();
//		e = new Employee();
//		e.setEmployeeId(1579349);
//		e.setEmployeeName("Amerita Singh");
//		e.setGender("Female");
//		e.setDesignation("Associate");
//		e.setEmail("email@tcs.com");
//		int numOfEmpUpdated = employeeDao.updateEmployee(e);
//		System.out.println("Number of Employees Updated: " + numOfEmpUpdated);
		
		int employeeId = 1579349;
		employeeDao = new EmployeeDao();
		int numberofEmployeesDeleted = employeeDao.deleteEmployee(employeeId);
		System.out.println("Number of Employees Deleted: " + numberofEmployeesDeleted);
	}

}