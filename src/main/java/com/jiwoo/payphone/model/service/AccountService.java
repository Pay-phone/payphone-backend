package com.jiwoo.payphone.model.service;

import com.jiwoo.payphone.model.dto.Account;

public interface AccountService {

	Account createAccount(Long userId);

	Account getAccountById(Long accountId);
	
	boolean isAccountNumberExists(String accountNumber);

}
