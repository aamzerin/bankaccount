package io.aamzerin.kata.bankaccount.service;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import io.aamzerin.kata.bankaccount.domain.Account;
import io.aamzerin.kata.bankaccount.domain.Client;
import io.aamzerin.kata.bankaccount.domain.Operation;
import io.aamzerin.kata.bankaccount.repository.AccountRepository;

public class AccountServiceTest {

	@Mock
	AccountRepository accountRepository;
	
	@InjectMocks
	AccountRepository accountservice;
	
	private Client client;
	private Account account;
	private Operation operation;
	
	
    @Before
    public void setUp() {

        //given
        client = Client.builder().clientId(1L).firstName("John").secondName("Doe").username("jdoe").build();
        account = Account.builder().accountNumber("0500013M026").client(client).balance(new BigDecimal(100000)).build();
        operation = Operation.builder().account(account).build();
        //when
    }
	
	@Test
	public void makeDepositinAccount() {
		
		
	}
	
	@Test
	public void makeWithdrawalinAccount() {
		
	}
	
	@Test
	public void retrieveOperationsHistory() {
		
	}
	
}
