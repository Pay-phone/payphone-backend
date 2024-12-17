package com.jiwoo.payphone.model.dto;

import java.time.LocalDateTime;

public class Account {
	private Long accountId; 
	private String accountNumber;
	private Long userId; 
	private Long balance; 
	private LocalDateTime createdAt;
	
	public Account() {}
	
	public Account(String accountNumber, Long userId, Long balance) {
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.balance = balance;
    }

	public Account(Long accountId, String accountNumber, Long userId, Long balance, LocalDateTime createdAt) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.userId = userId;
		this.balance = balance;
		this.createdAt = createdAt;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", userId=" + userId
				+ ", balance=" + balance + ", createdAt=" + createdAt + "]";
	}
	
	

}
