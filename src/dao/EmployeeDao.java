/**
 *Data Access Object (DAO) interface for Employee entities.
 *Defines the contract for employee persistence operations,
 *decoupling the application layer from the persistence technology.
*/

package dao;

import java.util.List;

import entities.Employee;

public interface EmployeeDao {

	
	 /**
     * Inserts a new employee into the data source.
     *
     * @param obj the employee to be inserted
     */
	 void insert(Employee employee);
	
	 
	 /**
	 * Retrieves all employees from the data source.
	 *
	 * @return a list of employees
	 */
	 List<Employee> findAll();

}
