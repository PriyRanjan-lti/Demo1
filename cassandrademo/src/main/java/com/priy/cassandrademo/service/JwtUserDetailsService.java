package com.priy.cassandrademo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;
import com.priy.cassandrademo.jwtmodel.UserDTO;
import com.priy.cassandrademo.model.User;
import com.priy.cassandrademo.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public User save(UserDTO user) {
		User newUser = new User();
		newUser.setId(UUIDs.timeBased());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(newUser);
	}

}