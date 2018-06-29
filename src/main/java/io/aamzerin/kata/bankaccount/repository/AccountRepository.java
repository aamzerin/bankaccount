package io.aamzerin.kata.bankaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.aamzerin.kata.bankaccount.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	public Account findByAccountNumber(String accountNumber);

}
