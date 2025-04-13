package auth;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		Connection connection=null;
		
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/authen","root","Rajan@2003");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return connection;
		
		
		
	}
}