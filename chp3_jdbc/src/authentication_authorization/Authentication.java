package authentication_authorization;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Authentication {
  public static String authenticateUser(String username,String password) {
	  String role=null;
	  
	  try {
		String sql="select * from users where username=? and password=?";
		PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(sql);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			role=resultSet.getString("role");
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println(e);
	}
	  
	  return role;
	  
  }
}
