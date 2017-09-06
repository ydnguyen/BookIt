package DataManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataStore {

	static Connection myConnection = null;
	
	 public static Connection getConnection()
	  {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
		  
		try {
			myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookIt", "root", "archie123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return myConnection;
	 }
}