package auth_with_swing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Authentication {
   
	
	public static User authenticateUser(String username,String password) {
		User user=null;
		
		try {
			String sql="select * from users where username=? and password=?";
			PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				user=new User();
				user.setId(resultSet.getInt(1));
				user.setUsername(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setRole(resultSet.getString(4));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		
		
		return user;
	}
}
