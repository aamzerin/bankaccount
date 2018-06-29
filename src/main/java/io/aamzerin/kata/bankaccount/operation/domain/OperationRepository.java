package io.aamzerin.kata.bankaccount.operation.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface OperationRepository.
 */
public interface OperationRepository extends JpaRepository<Operation, Long> {

	/**
	 * Find by account account number.
	 *
	 * @param accountNumber
	 *            the account number
	 * @return the list
	 */
	public List<Operation> findByAccountAccountNumber(String accountNumber);

}
