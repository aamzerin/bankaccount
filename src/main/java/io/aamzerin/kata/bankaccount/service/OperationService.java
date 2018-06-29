package io.aamzerin.kata.bankaccount.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.aamzerin.kata.bankaccount.domain.Account;
import io.aamzerin.kata.bankaccount.domain.Operation;

@Service
public class OperationService {
	
	@Autowired
	OperationService operationService;
	
	public Operation createOperation(Account account, BigDecimal amount, Integer entryType) {
		
		return null;
	}

}
