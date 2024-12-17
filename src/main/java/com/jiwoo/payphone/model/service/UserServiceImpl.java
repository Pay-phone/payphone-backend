package com.jiwoo.payphone.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jiwoo.payphone.jwt.JwtUtil;
import com.jiwoo.payphone.model.dao.UserDao;
import com.jiwoo.payphone.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	//회원가입 
	@Override
	public void registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("user");
		userDao.insertUser(user);
		
	}
	
	//로그인 처리 및 JWT 발급 
	@Override
	public String login(String username, String password) {
		User user = userDao.findByUsername(username);
		if(user != null && passwordEncoder.matches(password, user.getPassword())) {
			//JWT 토큰 발급
			return jwtUtil.generateToken(user.getUserId(), password);
		}
		return null;
	}

}
