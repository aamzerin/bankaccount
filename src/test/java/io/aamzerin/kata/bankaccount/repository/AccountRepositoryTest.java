package io.aamzerin.kata.bankaccount.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import io.aamzerin.kata.bankaccount.domain.Account;
import io.aamzerin.kata.bankaccount.domain.Client;

/**
 * Created by ghazala on 01/12/16.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

	/** The account repository. */
	@Autowired
	private AccountRepository accountRepository;
	
	/** The test entity manager. */
	@Autowired
	private TestEntityManager testEntityManager;
	
	/** The account. */
	private Account account;
	
	/** The client. */
	private Client client;

	/**
	 * Inits the.
	 */
	@Before
	public void setUp() {
		client = Client.builder().firstName("John").secondName("Doe").build();
		account = Account.builder().accountNumber("0500013M026").balance(new BigDecimal(1000L)).client(client).build();
		testEntityManager.persist(client);
		testEntityManager.persist(account);
	}

	/**
	 * Make deposit in account.
	 */
	@Test
	public void depositInAccount() {
		Account dbAccount = accountRepository.findByAccountNumber("0500013M026");
		dbAccount.setBalance(dbAccount.getBalance().add(new BigDecimal(500L)));
		accountRepository.save(dbAccount);
		Account updatedAccount = accountRepository.findByAccountNumber("0500013M026");
		Assert.assertNotNull(updatedAccount);
		assertThat(updatedAccount.getBalance()).isEqualByComparingTo(new BigDecimal(1500L));
	}
	
	/**
	 * Make deposit in account.
	 */
	@Test
	public void withdrawFromAccount() {
		Account dbAccount = accountRepository.findByAccountNumber("0500013M026");
		dbAccount.setBalance(dbAccount.getBalance().subtract(new BigDecimal(500L)));
		accountRepository.save(dbAccount);
		Account updatedAccount = accountRepository.findByAccountNumber("0500013M026");
		Assert.assertNotNull(updatedAccount);
		assertThat(updatedAccount.getBalance()).isEqualByComparingTo(new BigDecimal(500));
	}

	/**
	 * Retrieve account data by account number.
	 */
	@Test
	public void retrieveAccountDataByAccountNumber() {
		Account dbAccount = accountRepository.findByAccountNumber("0500013M026");

		Assert.assertNotNull(dbAccount);
		assertThat(dbAccount).isEqualToComparingFieldByFieldRecursively(account);
	}

}
