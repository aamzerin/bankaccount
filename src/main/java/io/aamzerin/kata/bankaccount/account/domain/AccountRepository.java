package io.aamzerin.kata.bankaccount.account.domain;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * The Interface AccountRepository.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

	/**
	 * Find by account number.
	 *
	 * @param accountNumber the account number
	 * @return the account
	 */
	public Account findByAccountNumber(String accountNumber);

	/**
	 * Update account balance.
	 *
	 * @param balance the balance
	 * @param accountNumber the account number
	 * @return the int
	 */
	@Modifying
	@Query("UPDATE Account a SET a.balance = :balance WHERE a.accountNumber = :accountNumber")
	int updateAccountBalance(@Param("balance") BigDecimal balance, @Param("accountNumber") String accountNumber);

}
