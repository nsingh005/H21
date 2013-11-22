package cs445.project.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionFactory {
	
	public DBConnectionFactory() throws ServiceLocatorException {
	}
	
	
	public Connection createConnection() throws ServiceLocatorException {
		try {
			
			return getMYSqlConnection();
		}
		catch (Exception e) {
			throw new ServiceLocatorException("Unable to create connection: " + e.getMessage(), e);
		}
	}
	
	public static Connection getMYSqlConnection(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/h21", "root", "root123");

		}catch (ClassNotFoundException ex) {
		      ex.printStackTrace();
		}catch (SQLException ex) {
		      System.out.println("SQL Exception occured" + ex);
	    }
	    catch (Exception ex) {
	      System.out.println("Genral Exception occured" + ex);
	    }
		
		return conn;
	}
}
