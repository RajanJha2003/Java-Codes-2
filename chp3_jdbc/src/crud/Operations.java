package crud;

import java.util.List;

public interface Operations {
	boolean addUser(User user);
	 List<User> getAllUsers();
	 boolean updateUser(User user);
	 boolean deleteUser(int id);
	 User searchUser(String username);

}
