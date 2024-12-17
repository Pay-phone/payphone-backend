package com.jiwoo.payphone.model.service;

import com.jiwoo.payphone.model.dto.User;

public interface UserService {
	 void registerUser(User user);
	 String login(String username, String password);
}
