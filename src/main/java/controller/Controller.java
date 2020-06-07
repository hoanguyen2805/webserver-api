package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import entity.*;
import service.UserService;

@RestController
public class Controller {
	@Autowired
	UserService userService;

	/* ---------------- GET ALL User ------------------------ */
	@RequestMapping(value = { "/users", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> listUsers = new ArrayList<User>();
		listUsers = userService.getAllUsers();
		return new ResponseEntity<List<User>>(listUsers, HttpStatus.OK);
	}

	/* ---------------- GET User BY ID ------------------------ */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getUserById(@PathVariable int id) {
		User User = userService.getUserById(id);
		if (User != null) {
			return new ResponseEntity<Object>(User, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Not Found User", HttpStatus.NO_CONTENT);
	}

	/* ---------------- CREATE NEW User ------------------------ */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {
		if (userService.getUserByName(user.getUsername()) != null) {
			return new ResponseEntity<String>("User Already Exist!", HttpStatus.CONFLICT);
		}
		userService.addUser(user);
		return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
	}

	/* ---------------- DELETE User ------------------------ */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUserById(@PathVariable int id) {
		User User = userService.getUserById(id);
		if (User == null) {
			return new ResponseEntity<String>("Not Found User", HttpStatus.OK);
		}
		userService.deleteUser(id);
		return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
	}

	/* ---------------- UPDATE User ------------------------ */
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		User oldUser = userService.getUserById(user.getId());
		if (oldUser == null) {
			return new ResponseEntity<String>("Not Found User!", HttpStatus.NO_CONTENT);
		}
		userService.updateUser(user);
		return new ResponseEntity<String>("Updated!", HttpStatus.OK);
	}

	/* ---------------- PAGINATION User ----------------------- */
	@RequestMapping(value = { "/pages/{page}", }, method = RequestMethod.GET)
	public ResponseEntity<List<User>> paginationUsers(@PathVariable int page) {
		if (page <= 0) {
			page = 1;
		}
		List<User> listUsers = new ArrayList<User>();
		listUsers = userService.paginationUsers(page);
		return new ResponseEntity<List<User>>(listUsers, HttpStatus.OK);
	}
}
