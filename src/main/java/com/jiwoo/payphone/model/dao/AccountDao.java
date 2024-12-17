package com.jiwoo.payphone.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jiwoo.payphone.model.dto.Account;

@Mapper
public interface AccountDao {
	void insertAccount(Account account);
	Account selectAccountById(Long accoundId);
	int isAccountNumberExists(String accountNumber);

}
