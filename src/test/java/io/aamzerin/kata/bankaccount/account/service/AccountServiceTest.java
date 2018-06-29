package io.aamzerin.kata.bankaccount.account.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import io.aamzerin.kata.bankaccount.account.domain.Account;
import io.aamzerin.kata.bankaccount.account.domain.AccountRepository;
import io.aamzerin.kata.bankaccount.account.service.AccountService;
import io.aamzerin.kata.bankaccount.client.domain.Client;
import io.aamzerin.kata.bankaccount.constant.EntryType;
import io.aamzerin.kata.bankaccount.operation.domain.Operation;
import io.aamzerin.kata.bankaccount.operation.service.OperationService;

/**
 * The Class AccountServiceTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

	/** The account repository. */
	@Mock
	AccountRepository accountRepository;

	/** The operation service. */
	@Mock
	OperationService operationService;

	/** The account service. */
	@InjectMocks
	AccountService accountService;

	/** The client. */
	private Client client;

	/** The account. */
	private Account account;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {

		client = Client.builder().clientId(1L).firstName("John").secondName("Doe").username("jdoe").build();
		account = Account.builder().accountNumber("0500013M026").client(client).balance(new BigDecimal(1000)).build();
	}

	/**
	 * Make credit operation.
	 */
	@Test
	public void makeCreditOperation() {

		Account creditedAccount = account;
		Mockito.when(operationService.createOperation(account, new BigDecimal(500L), EntryType.DEBIT.getEntryType()))
				.thenReturn(new Operation(1l, new BigDecimal(500L), EntryType.DEBIT.getEntryType(), LocalDateTime.now(),
						account));

		creditedAccount.setBalance(account.getBalance().add(new BigDecimal(500L)));
		Mockito.when(accountRepository.findByAccountNumber(account.getAccountNumber())).thenReturn(creditedAccount);

		accountService.makeAccountOperation(account, new BigDecimal(500L), EntryType.DEBIT.getEntryType());

		assertThat(creditedAccount.getBalance()).isEqualByComparingTo(new BigDecimal(1500));

	}

	/**
	 * Make debit operation.
	 */
	@Test
	public void makeDebitOperation() {

		Account debitedAccount = account;
		Mockito.when(operationService.createOperation(account, new BigDecimal(500L), EntryType.DEBIT.getEntryType()))
				.thenReturn(new Operation(1l, new BigDecimal(500L), EntryType.DEBIT.getEntryType(), LocalDateTime.now(),
						account));

		debitedAccount.setBalance(account.getBalance().subtract(new BigDecimal(500L)));

		accountService.makeAccountOperation(account, new BigDecimal(500L), EntryType.DEBIT.getEntryType());

		assertThat(debitedAccount.getBalance()).isEqualByComparingTo(new BigDecimal(500));

	}

	// @Test
	// public void getHistory() {
	//
	// }

}
