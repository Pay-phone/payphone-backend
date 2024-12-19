package com.jiwoo.payphone.model.service;

import java.util.HashMap;
import java.util.Map;

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
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setRole("user");
			userDao.insertUser(user);
			
		} catch(Exception e) {
			// 예외 발생 시 로깅
	        System.err.println("Error registering user: " + e.getMessage());
	        throw e;
		}
		
	}
	
	//로그인 처리 및 JWT 발급 
	@Override
	public Map<String, Object> login(String username, String password) {
		User user = userDao.findByUsername(username);
		if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // JWT 토큰 생성
            String token = jwtUtil.generateToken(user.getUserId(), user.getUsername());

            // 응답 데이터 생성
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);

            // 사용자 정보에서 필요한 데이터만 포함
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("userId", user.getUserId());
            userInfo.put("username", user.getUsername());
            userInfo.put("email", user.getEmail());

            response.put("user", userInfo);

            return response;
        }
		
		return null;
	}

}