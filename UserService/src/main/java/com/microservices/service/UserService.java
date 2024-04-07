package com.microservices.service;

import java.util.List;
import java.util.Optional;

import com.microservices.model.User;

public interface UserService {

	// Method to save a new user
	User saveUser(User user);

	// Method to update an existing user
	User updateUser(Long userId, User user);

	// Method to delete a user by ID
	void deleteUser(Long userId);

	// Method to find a user by ID
	Optional<User> getUserById(Long userId);

	// Method to find all users
	List<User> getAllUsers();

}
