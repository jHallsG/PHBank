package com.phbank.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class RegistrationImpl {
	
	private final PasswordEncoder passwordEncoder;
	private final UserDetailsManager userDetailsManager;
	
	public RegistrationImpl(PasswordEncoder passwordEncoder, UserDetailsManager userDetailsManager) {
		this.passwordEncoder = passwordEncoder;
		this.userDetailsManager = userDetailsManager;
	}
	
	public void registerUser(String username, String password) {
		
		UserDetails newUser = User
				.withUsername(username)
				.password(passwordEncoder.encode(password))
				.roles("USER")
				.build();
		
		userDetailsManager.createUser(newUser);
	}
}
