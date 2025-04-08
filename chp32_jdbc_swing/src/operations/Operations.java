package operations;

import java.util.List;

import model.User;

public interface Operations {
	 boolean addUser(User user);
	 List<User> getAllUsers();
	 boolean updateUser(User user);
	 boolean deleteUser(int id);
	 User searchUser(int id);
	 boolean loginUser(String email, String password);
	 User getUserById(int id) ;

}