package operationsImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DbConnection;
import model.User;
import operations.Operations;

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
			
			e.printStackTrace();
			System.out.println(e);
		}
		return success;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<User>();
		try {
			String sql="select * from users";
			PreparedStatement preparedStatement=DbConnection.getConnection().prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				User user=new User();
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
			System.out.println(e);
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean updateUser(User user) {
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
            
            int updated=preparedStatement.executeUpdate();
            if(updated==1) {
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
		boolean success=false;
		try {
			String sql="delete from users where id=?";
			PreparedStatement preparedStatement=DbConnection.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			int deleted=preparedStatement.executeUpdate();
			
			if(deleted==1) {
				System.out.println("Deleted successfully");
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
	public User searchUser(int id) {
	    User user = null;
	    try {
	        String sql = "SELECT * FROM users WHERE id = ?";
	        PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(sql);
	        preparedStatement.setInt(1, id);

	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            user = new User();
	            user.setId(resultSet.getInt("id"));
	            user.setUsername(resultSet.getString("username"));
	            user.setPassword(resultSet.getString("password"));
	            user.setEmail(resultSet.getString("email"));
	            user.setPhone(resultSet.getString("phone"));
	            user.setGender(resultSet.getString("gender"));
	            user.setCity(resultSet.getString("city"));
	            System.out.println("User found: " + id);
	        } else {
	            System.out.println("User not found: " + id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println(e);
	    }
	    return user;
	}


	@Override
	public boolean loginUser(String email, String password) {
		boolean success=false;
		
		try {
			String sql="select * from users where email=? and password=?";
			PreparedStatement preparedStatement=DbConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
            
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				success=true;
				System.out.println("logged in");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		
		return success;
	}

	@Override
	public User getUserById(int id) {
	    User user = null;
	    try {
	        String sql = "SELECT * FROM users WHERE id = ?";
	        PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(sql);
	        preparedStatement.setInt(1, id);

	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            user = new User();
	            user.setId(resultSet.getInt("id"));
	            user.setUsername(resultSet.getString("username"));
	            user.setPassword(resultSet.getString("password"));
	            user.setEmail(resultSet.getString("email"));
	            user.setPhone(resultSet.getString("phone"));
	            user.setGender(resultSet.getString("gender"));
	            user.setCity(resultSet.getString("city"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return user;
	}


}
