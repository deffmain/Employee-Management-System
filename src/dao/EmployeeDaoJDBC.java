/**
 * JDBC implementation of EmployeeDao.
 * <p>
 * This class is responsible for performing database operations
 * using JDBC, isolating SQL and connection handling from
 * the application layer.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import entities.Employee;

public class EmployeeDaoJDBC implements EmployeeDao {

	
	//---
	@Override
	public void insert(Employee obj) {

		String sql = 
				"INSERT INTO employee (name, hours, value_per_hour) VALUES (?,?,?)";
		try(Connection conn= DB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

			st.setString(1, obj.getName());
			st.setInt(2, obj.getHours());
			st.setDouble(3, obj.getValuePerHouer());

			int rowsAffected = st.executeUpdate();

			if(rowsAffected > 0) {

				try(ResultSet rs = st.getGeneratedKeys()){

					if(rs.next()) {
						obj.setId(rs.getInt(1));
					}
				}
			}
			else {
				throw new DbException("Unexpected error: no rows affected");
			}


		}catch(SQLException e) {
			throw new DbException(e.getMessage(),e);
		}
	}
	//--/
	
	
	//---
	@Override
	public List<Employee> findAll(){

		List<Employee> list = new ArrayList<>();

		String sql = "SELECT * FROM employee";

		try(Connection conn = DB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				ResultSet rs = st.executeQuery()

				){

			while(rs.next()) {

				Employee emp = new Employee();

				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setHours(rs.getInt("hours"));
				emp.setValuePerHouer(rs.getDouble("value_per_hour"));


				list.add(emp);
			}

		} catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		return list;
	}
	//--/

}