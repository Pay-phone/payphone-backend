package com.jiwoo.payphone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiwoo.payphone.model.dto.Account;
import com.jiwoo.payphone.model.service.AccountService;

@RestController
@RequestMapping("/api/account")
@CrossOrigin("*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	//계좌 생성
	@PostMapping("/create")
	public ResponseEntity<?> createAccount(@RequestBody Account account) {
		Account createdAccount = accountService.createAccount(account.getUserId());
		return ResponseEntity.ok(createdAccount);
	}
	
	//userId에 따른 전체 계좌 조회 
	@GetMapping("user/{userId}")
	public ResponseEntity<?> getAccountByUserId(@PathVariable Long userId) {
		try {
            List<Map<String, Object>> accounts = accountService.getAccountsByUserId(userId);
            if (accounts.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No accounts found for the given userId");
            }
            return ResponseEntity.ok(accounts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching accounts: " + e.getMessage());
        }
	}
	
	//상세 계좌 조회
	@GetMapping("/{accountId}")
	public ResponseEntity<?> getAccountById(@PathVariable Long accountId) {
        Account account = accountService.getAccountById(accountId);

        if (account == null) {
            return ResponseEntity.status(404).body("Account not found");
        }

        return ResponseEntity.ok(account);
    }

}
