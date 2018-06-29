package io.aamzerin.kata.bankaccount.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.aamzerin.kata.bankaccount.domain.Account;
import io.aamzerin.kata.bankaccount.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	OperationService operationService;
	
	@Test
	public void makeAccountOperation(Account account,BigDecimal amount,Integer entryType) {
		
	}
	
	@Test
	public void getAccountHistory(Account account) {
		
	}

}
