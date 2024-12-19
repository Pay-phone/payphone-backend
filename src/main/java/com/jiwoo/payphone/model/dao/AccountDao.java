package com.jiwoo.payphone.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jiwoo.payphone.model.dto.Account;

@Mapper
public interface AccountDao {
	void insertAccount(Account account);
	Account selectAccountById(Long accoundId);
	int isAccountNumberExists(String accountNumber);
	List<Map<String, Object>> findAccountsByUserId(Long userId);

}
