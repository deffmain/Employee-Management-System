/**
 * Factory class responsible for creating DAO implementations.
 * <p>
 * Centralizes the instantiation logic and allows easy replacement
 * of persistence technologies without impacting the application layer.
 */


package dao;

public class DaoFactory {
	
	public static EmployeeDao createEmployeeDao() {
		return new EmployeeDaoJDBC();
		
	}

}
