package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OperationsImp implements Operations {

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		boolean success=false;
		try {
			String sql="insert into users(username,password,email,phone,gender,city) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement=DbConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setString(5, user.getGender());
			preparedStatement.setString(6, user.getCity());
			
			int add=preparedStatement.executeUpdate();
			if(add==1) {
				success=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		return success;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<User>();
		User user=null;
		try {
			String sql="select * from users";
			PreparedStatement preparedStatement=DbConnection.getConnection().prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				user=new User();
				user.setId(resultSet.getInt(1));
				user.setUsername(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setEmail(resultSet.getString(4));
				user.setPhone(resultSet.getString(5));
				user.setGender(resultSet.getString(6));
				user.setCity(resultSet.getString(7));
				list.add(user);
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		return list;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User searchUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
