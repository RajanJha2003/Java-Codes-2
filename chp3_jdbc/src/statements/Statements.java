package statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statements {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","Rajan@2003");
        
		Statement statement=connection.createStatement();
		statement.execute("Insert into user values(1,'Rajan','09766')");
		statement.execute("Insert into user values(2,'King','4855')");
		statement.execute("Insert into user values(3,'Developer','55255')");
		
		ResultSet resultSet=statement.executeQuery("select * from user");
		
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
			
		}
		
		connection.close();
		
	}

}
