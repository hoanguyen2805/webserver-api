package service;

import java.util.List;

import entity.*;

public interface UserService {
	public void addUser(User User);

	public void updateUser(User User);

	public void deleteUser(int id);

	public User getUserById(int id);

	public User getUserByName(String name);

	public List<User> getAllUsers();

	public List<User> paginationUsers(int page);
}
