package com.jiwoo.payphone.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jiwoo.payphone.model.dto.User;

@Mapper
public interface UserDao {
	void insertUser(User user);
	User findByUsername(String string);

}
