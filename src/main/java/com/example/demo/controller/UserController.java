package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.service.UserService;

/**
 * 
 * @author Versha Mehra
 *
 */
@RestController
//@RequestMapping("api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @param user
	 * @return saved user entity
	 * @throws UserAlreadyExistsException
	 */
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) throws UserAlreadyExistsException {
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return user object if present
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable int id) {
		Optional<User> user = userService.getUserById(id);
		return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
	}

	@DeleteMapping("user/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable int id) {
		String str = userService.deleteUserById(id);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@GetMapping("/users/{name}")
	public ResponseEntity<List<User>> getUserByFirstName(@PathVariable String name) {
		List<User> user = userService.getUserByName(name);
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}
}