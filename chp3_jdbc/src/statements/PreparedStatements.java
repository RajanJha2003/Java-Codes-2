package statements;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatements {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","Rajan@2003");
        
		 String sql = "INSERT INTO user (id, name, contact) VALUES (?, ?, ?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, 4);
        preparedStatement.setString(2, "Rajan");
        preparedStatement.setString(3, "09766");
        preparedStatement.executeUpdate();

        
        preparedStatement.setInt(1, 5);
        preparedStatement.setString(2, "King");
        preparedStatement.setString(3, "4855");
        preparedStatement.executeUpdate();

        
        preparedStatement.setInt(1, 6);
        preparedStatement.setString(2, "Developer");
        preparedStatement.setString(3, "55255");
        preparedStatement.executeUpdate();
        
        String sql2="select * from user";
        PreparedStatement preparedStatement2=connection.prepareStatement(sql2);
        
        ResultSet resultSet=preparedStatement2.executeQuery();
        
        while (resultSet.next()) {
        	System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
			
		}
        
        connection.close();
        
        
        
		
	}

}
