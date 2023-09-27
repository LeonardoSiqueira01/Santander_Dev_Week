package com.lgs.model.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgs.model.User;
import com.lgs.model.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);

	}

	@Override
	public User create(User UserCreate) {

		if (userRepository.existsByAccountNumber(UserCreate.getAccount().getNumber())) {
			throw new IllegalArgumentException("This account number already exists!");
		}
		return userRepository.save(UserCreate);
	}

}
