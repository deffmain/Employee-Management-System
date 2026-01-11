/**
 * Custom runtime exception for database access errors.
 * <p>
 * This exception is used to wrap lower-level SQLExceptions
 * and propagate them as unchecked exceptions to higher layers.
 */

package db;

public class DbException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	//---
	public DbException(String msg) {
		super(msg);
	}
	//--/
	
	
    //---
	public DbException(String msg, Throwable cause) {
		super(msg, cause);
	}
	//--/

}
