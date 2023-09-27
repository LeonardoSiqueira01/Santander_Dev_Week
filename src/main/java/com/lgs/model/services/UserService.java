package com.lgs.model.services;

import com.lgs.model.User;

public interface UserService {
	User findById(Long id);

	User create(User UserCreate);
}
