package com.jiwoo.payphone.model.service;

import java.util.Map;

import com.jiwoo.payphone.model.dto.User;

public interface UserService {
	 void registerUser(User user);
	 Map<String, Object> login(String username, String password);
}
