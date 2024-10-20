package com.sarvika.technologies.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarvika.technologies.assignment.exception.UserNotFoundException;
import com.sarvika.technologies.assignment.model.User;
import com.sarvika.technologies.assignment.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User updateUser(Long id, User userDetails) {
		User user = getUserById(id);
		
		if (userDetails.getFirstName() != null) {
			user.setFirstName(userDetails.getFirstName());
		}
		if (userDetails.getLastName() != null) {
			user.setLastName(userDetails.getLastName());
		}
		if (userDetails.getEmail() != null) {
			user.setEmail(userDetails.getEmail());
		}
		if (userDetails.getPhoneNumber() != null) {
			user.setPhoneNumber(userDetails.getPhoneNumber());
		}
		if (userDetails.getAddress() != null) {
			user.setAddress(userDetails.getAddress());
		}

		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		User user = getUserById(id);
		userRepository.delete(user);
	}
}
