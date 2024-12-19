package com.jiwoo.payphone.model.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiwoo.payphone.model.dao.AccountDao;
import com.jiwoo.payphone.model.dto.Account;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDao accountDao;
	
	//계좌 생성 
	@Override
	public Account createAccount(Long userId) {
		String accountNumber;
		
		// 고유한 계좌번호 생성 및 중복 체크
	    do {
	        accountNumber = generateAccountNumber();
	    } while(isAccountNumberExists(accountNumber)); // DB에 중복 체크
	    
	    Account account = new Account(accountNumber, userId, 0L);
	    accountDao.insertAccount(account);

	    return account;

	}

	//세부 계좌 조회 
	@Override
	public Account getAccountById(Long accountId) {
		return accountDao.selectAccountById(accountId);
	}
	
	// 유일한 계좌번호 생성 (10자리 숫자)
	private String generateAccountNumber() {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < 10; i++) {
	        sb.append((int)(Math.random() * 10)); // 0~9 사이의 숫자 랜덤 추가
	    }
	    return sb.toString();
	}

	
	// 계좌번호 유일한지 확인 
	@Override
	public boolean isAccountNumberExists(String accountNumber) {
	    int result = accountDao.isAccountNumberExists(accountNumber);
	    return result > 0; // 결과가 1이상이면 true 반환  
	}



	//userId에 따른 전체 계좌 조회 
	@Override
	public List<Map<String, Object>> getAccountsByUserId(Long userId) {
		return accountDao.findAccountsByUserId(userId);
	}

}
