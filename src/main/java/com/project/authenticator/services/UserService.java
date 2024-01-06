package com.project.authenticator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.authenticator.entities.Users;
import com.project.authenticator.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public List<Users> findAll() {
		List<Users> response = this.userRepository.findAll();
		return response;
	}
	
	public Users save(Users user) {
		return this.userRepository.save(user);
	}
}
