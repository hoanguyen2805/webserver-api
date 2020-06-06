package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import entity.*;
import service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao UserDao;

	public void addUser(User User) {
		UserDao.addUser(User);

	}

	public void updateUser(User User) {
		UserDao.updateUser(User);
	}

	public void deleteUser(int id) {
		UserDao.deleteUser(id);
	}

	public User getUserById(int id) {
		return UserDao.getUserById(id);
	}

	public List<User> getAllUsers() {
		return UserDao.getAllUsers();
	}
	public User getUserByName(String name) {
		return UserDao.getUserByName(name);
	}
}
