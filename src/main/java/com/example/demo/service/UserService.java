package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;
import com.example.demo.exception.UserAlreadyExistsException;

public interface UserService {

	User saveUser(User user) throws UserAlreadyExistsException;

	List<User> getAllUsers();

	Optional<User> getUserById(int id);

	String deleteUserById(int id);

	List<User> getUserByName(String firstName);
}
