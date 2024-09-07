package E_preparationSystem;

import java.sql.Connection;
import java.sql.DriverManager;
// Global connection Class
public class connection {
	static Connection con; 
	public static Connection getConnection()
	{
		try {
			
			
			String mysqlJDBCDriver
				= "com.mysql.cj.jdbc.Driver"; 
			String url
				= "jdbc:mysql://localhost:3306/Epreparation"; 
			String user = "root";	 
			String pass = "root"; 
			Class.forName(mysqlJDBCDriver);
			con = DriverManager.getConnection(url, user, pass);
		}
		catch (Exception e) {
			System.out.println("Connection Failed!");
		}

		return con;
	}
}