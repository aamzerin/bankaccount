package io.aamzerin.kata.bankaccount.operation.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.aamzerin.kata.bankaccount.account.domain.Account;
import io.aamzerin.kata.bankaccount.operation.domain.Operation;

/**
 * The Class OperationService.
 */
@Service
public class OperationService {

	/** The operation service. */
	@Autowired
	OperationService operationService;

	/**
	 * Creates the operation.
	 *
	 * @param account
	 *            the account
	 * @param amount
	 *            the amount
	 * @param entryType
	 *            the entry type
	 * @return the operation
	 */
	public Operation createOperation(Account account, BigDecimal amount, Integer entryType) {

		return null;
	}

}
