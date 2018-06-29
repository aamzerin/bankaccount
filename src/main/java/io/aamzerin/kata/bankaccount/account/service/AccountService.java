package io.aamzerin.kata.bankaccount.account.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.aamzerin.kata.bankaccount.account.domain.Account;
import io.aamzerin.kata.bankaccount.account.domain.AccountRepository;
import io.aamzerin.kata.bankaccount.operation.service.OperationService;

/**
 * The Class AccountService.
 */
@Service
public class AccountService {

	/** The account repository. */
	@Autowired
	AccountRepository accountRepository;

	/** The operation service. */
	@Autowired
	OperationService operationService;

	/**
	 * Make account operation.
	 *
	 * @param account the account
	 * @param amount the amount
	 * @param entryType the entry type
	 * @return the account
	 */
	public Account makeAccountOperation(Account account, BigDecimal amount, Integer entryType) {

		operationService.createOperation(account, amount, entryType);
		accountRepository.updateAccountBalance(account.getBalance().add(amount.multiply(new BigDecimal(entryType))),
				account.getAccountNumber());

		return accountRepository.findByAccountNumber(account.getAccountNumber());

	}

}
