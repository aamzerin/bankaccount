package io.aamzerin.kata.bankaccount.operation.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.aamzerin.kata.bankaccount.account.domain.Account;
import io.aamzerin.kata.bankaccount.account.domain.AccountRepository;
import io.aamzerin.kata.bankaccount.client.domain.Client;
import io.aamzerin.kata.bankaccount.constant.EntryType;
import io.aamzerin.kata.bankaccount.operation.domain.Operation;
import io.aamzerin.kata.bankaccount.operation.domain.OperationRepository;

/**
 * The Class OperationRepositoryTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class OperationRepositoryTest {

	/** The account repository. */
	@Autowired
	private OperationRepository operationRepository;
	
	/** The account repository. */
	@Autowired
	private AccountRepository accountRepository;

	/** The test entity manager. */
	@Autowired
	private TestEntityManager testEntityManager;

	/** The account. */
	private Account account;

	/** The client. */
	private Operation operation;

	/** The client. */
	private Client client;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {	
		client = Client.builder().firstName("John").secondName("Doe").build();
		account = Account.builder().accountNumber("0500013M026").balance(new BigDecimal(1000L)).client(client).build();
		operation = Operation.builder().amount(new BigDecimal(500L)).account(account).build();
		testEntityManager.persist(client);
		testEntityManager.persist(account);
	}
	
	/**
	 * Make credit operation.
	 */
	@Test
	public void makeCreditOperation()
	{
		Account dbAccount = accountRepository.findByAccountNumber("0500013M026");
		operation.setEntryType(EntryType.CREDIT.getEntryType());
		operation.setDate(LocalDateTime.now());
		dbAccount.setBalance(dbAccount.getBalance().add(operation.getAmount()));
		accountRepository.save(dbAccount);
		operationRepository.save(operation);
		
		List<Operation> createdOperations = operationRepository.findByAccountAccountNumber("0500013M026");

        assertThat(createdOperations, not(IsEmptyCollection.empty()));
		assertThat(createdOperations, contains(operation));
		
		Account updatedAccount = accountRepository.findByAccountNumber("0500013M026");
		Assert.assertNotNull(updatedAccount);
		assertThat(updatedAccount.getBalance()).isEqualByComparingTo(new BigDecimal(1500L));
		
	}
	
	/**
	 * Make operation.
	 */
	@Test
	public void makeOperation()
	{
		Account dbAccount = accountRepository.findByAccountNumber("0500013M026");
		operation.setEntryType(EntryType.DEBIT.getEntryType());
		operation.setDate(LocalDateTime.now());
		dbAccount.setBalance(dbAccount.getBalance().subtract(operation.getAmount()));
		accountRepository.save(dbAccount);
		operationRepository.save(operation);
		
		List<Operation> createdOperations = operationRepository.findByAccountAccountNumber("0500013M026");

        assertThat(createdOperations, not(IsEmptyCollection.empty()));
		assertThat(createdOperations, contains(operation));
		
		Account updatedAccount = accountRepository.findByAccountNumber("0500013M026");
		Assert.assertNotNull(updatedAccount);
		assertThat(updatedAccount.getBalance()).isEqualByComparingTo(new BigDecimal(500L));
		
	}
}
