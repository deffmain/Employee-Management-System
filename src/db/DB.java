/**
 * Utility class responsible for providing database connections and
 * helper methods for closing JDBC resources.
 * <p>
 * Each call to {@link #getConnection()} returns a new database connection.
 * The responsibility for closing the connection lies with the caller,
 * typically using try-with-resources.
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	//---
	public static Connection getConnection() {


			try {
				return DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/your_database",
						"user",
						"password"

						);

			}catch (SQLException e) {
				throw new DbException("Error connecting to the database", e);

			}

		}
	//--/
	
	
	//---
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	//--/
	
	//---
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	//--/
	


}
