package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) throws UserAlreadyExistsException {
		if (userRepository.existsById(user.getId()))
			throw new UserAlreadyExistsException();

		User saveduser = userRepository.save(user);
		return saveduser;

	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}

	@Override
	public String deleteUserById(int id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return "id is deleted successfully";
		}
		return "id doesn't exist";
	}

	@Override
	public List<User> getUserByName(String firstName) {
		List<User> list = userRepository.findByFirstName(firstName);
		return list;
	}
}
