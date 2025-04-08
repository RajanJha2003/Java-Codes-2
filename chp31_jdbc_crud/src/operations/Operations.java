package operations;

import java.util.List;

import model.User;

public interface Operations {
	 boolean addUser(User user);
	 List<User> getAllUsers();
	 boolean updateUser(User user);
	 boolean deleteUser(int id);
	 User searchUser(String username);
	 boolean loginUser(String email, String password);
}