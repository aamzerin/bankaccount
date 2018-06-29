package io.aamzerin.kata.bankaccount.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.aamzerin.kata.bankaccount.domain.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
	
	public List<Operation> findByAccountAccountNumber(String accountNumber);

}
