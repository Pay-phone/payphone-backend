package com.jiwoo.payphone.model.service;

import java.util.List;
import java.util.Map;

import com.jiwoo.payphone.model.dto.Account;

public interface AccountService {

	Account createAccount(Long userId);

	Account getAccountById(Long accountId);
	
	boolean isAccountNumberExists(String accountNumber);

	List<Map<String, Object>> getAccountsByUserId(Long userId);

}
