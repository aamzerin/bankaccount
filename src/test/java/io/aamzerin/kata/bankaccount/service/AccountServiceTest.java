package io.aamzerin.kata.bankaccount.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.aamzerin.kata.bankaccount.constant.EntryType;
import io.aamzerin.kata.bankaccount.domain.Account;
import io.aamzerin.kata.bankaccount.domain.Client;
import io.aamzerin.kata.bankaccount.domain.Operation;
import io.aamzerin.kata.bankaccount.repository.AccountRepository;

public class AccountServiceTest {

	@Mock
	AccountRepository accountRepository;

	@Mock
	OperationService operationService;

	@InjectMocks
	AccountRepository accountservice;

	private Client client;
	private Account account;
	private Operation operation;

	@Before
	public void setUp() {

		client = Client.builder().clientId(1L).firstName("John").secondName("Doe").username("jdoe").build();
		account = Account.builder().accountNumber("0500013M026").client(client).balance(new BigDecimal(100000)).build();
		operation = Operation.builder().account(account).build();
	}

	@Test
	public void makeCreditOperation() {

		Mockito.when(accountRepository.save(account)).thenReturn(account);
		Mockito.when(operationService.createOperation(account, new BigDecimal(500L), EntryType.CREDIT.getEntryType()))
				.thenReturn(new Operation(1l, new BigDecimal(500L), EntryType.CREDIT.getEntryType(), LocalDateTime.now(), account));

	}
	
	@Test
	public void makeDebitOperation() {

		Mockito.when(accountRepository.save(account)).thenReturn(account);
		Mockito.when(operationService.createOperation(account, new BigDecimal(500L), EntryType.CREDIT.getEntryType()))
				.thenReturn(new Operation(1l, new BigDecimal(500L), EntryType.DEBIT.getEntryType(), LocalDateTime.now(), account));

	}


	@Test
	public void getHistory(Account account) {

	}

}
