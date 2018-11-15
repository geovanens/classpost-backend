package com.classpost.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classpost.models.User;
import com.classpost.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User save(User user) {
		user.setCreateDate(LocalDateTime.now());
		return this.userRepository.save(user);
	}
	
	public List<User> getAll() {
		return this.userRepository.findAll();
	}

	public User update(User user) throws Exception {
		User userUsername = this.findByUsername(user.getUsername());
		if (userUsername != null && userUsername.getUsername().equals(user.getUsername()) && !userUsername.getEmail().equals(user.getEmail())) {
			throw new Exception("Username já cadastrado para outro usuário");
		}
		User saved = this.userRepository.getOne(user.getEmail());
		saved.setUsername(user.getUsername());
		saved.setFirstName(user.getFirstName());
		saved.setLastName(user.getLastName());
		saved.setImage(user.getImage());
		saved.setPassword(user.getPassword());
		this.userRepository.save(saved);
		return saved;
	}

	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	public User delete(User user) {
		this.userRepository.delete(user);
		return user;
	}

	public User findByEmail(String email) {
		return this.userRepository.findById(email).get();
	}

}
