package crud_with_swing;

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
				System.out.println("User added successfully");
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
		boolean success=false;
		try {
			String sql = "UPDATE users SET username=?, password=?, email=?, phone=?, gender=?, city=? WHERE id=?";
			PreparedStatement preparedStatement=DbConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setString(5, user.getGender());
			preparedStatement.setString(6, user.getCity());
			preparedStatement.setInt(7, user.getId());
			
			int update=preparedStatement.executeUpdate();
			if(update==1) {
				success=true;
				System.out.println("User updated successfully");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		return success;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		boolean success=false;
		try {
			String sql="delete from users where id=?";
			PreparedStatement preparedStatement=DbConnection.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			int delete=preparedStatement.executeUpdate();
			
			if(delete==1) {
				success=true;
				System.out.println("user deleted successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		return false;
	}

	@Override
	public User searchUser(String username) {
		// TODO Auto-generated method stub
		User user=null;
		
		try {
			String sql="select * from users where username=?";
			PreparedStatement preparedStatement=DbConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, username);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				 user = new User();
		            user.setId(resultSet.getInt("id"));
		            user.setUsername(resultSet.getString("username"));
		            user.setPassword(resultSet.getString("password"));
		            user.setEmail(resultSet.getString("email"));
		            user.setPhone(resultSet.getString("phone"));
		            user.setGender(resultSet.getString("gender"));
		            user.setCity(resultSet.getString("city"));
		            System.out.println("User found: " + username);
              				
			}else {
				System.out.println("user not found"+username);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		return user;
	}
	@Override
	public User getUserById(int id) {
	    User user = null;
	   try {
		String sql="select * from users where id=?";
		PreparedStatement preparedStatement=DbConnection.getConnection().prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs=preparedStatement.executeQuery();
		if(rs.next()) {
			 user = new User();
	            user.setId(rs.getInt("id"));
	            user.setUsername(rs.getString("username"));
	            user.setEmail(rs.getString("email"));
	            user.setPhone(rs.getString("phone"));
	            user.setGender(rs.getString("gender"));
	            user.setCity(rs.getString("city"));
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println(e);
	}
	    return user;
	}


}
