package com.agelgil.agelgil.lib.extra.auth;

import com.agelgil.agelgil.lib.data.models.auth.User;
import com.agelgil.agelgil.lib.data.models.auth.User.Role;
import com.agelgil.agelgil.lib.data.repositories.auth.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;


public class UserManager {
	
	private UserRepository userRepository;
	private PasswordEncoder encoder;

	public UserManager(UserRepository userRepository, PasswordEncoder encoder){
		this.userRepository = userRepository;
		this.encoder = encoder;
	}

	public User createUser(String username, String password, Role role){
		
		User user = new User(
			username, 
			encoder.encode(password),
			true,
			false,
			role
		);
		
		this.userRepository.save(user);

		return user;

	}

	public boolean userExists(String username){
		return userRepository.existsById(username);
	}

}
