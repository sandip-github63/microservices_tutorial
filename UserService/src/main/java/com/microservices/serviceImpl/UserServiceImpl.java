package com.microservices.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.exception.CustomException;
import com.microservices.model.User;
import com.microservices.repository.UserRepository;
import com.microservices.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(Long userId, User user) {
		User existingUser = userRepository.findByUserId(userId)
				.orElseThrow(() -> new CustomException("User not found with id: " + userId));

		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setAbout(user.getAbout());

		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteByUserId(userId);
	}

	@Override
	public Optional<User> getUserById(Long userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
