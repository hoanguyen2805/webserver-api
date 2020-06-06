package dao;
import java.util.List;


import entity.*;;
public interface UserDao {
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public User getUserById(int id);
	public User getUserByName(String name);
	public List<User> getAllUsers();
}
