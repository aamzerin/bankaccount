package io.aamzerin.kata.bankaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.aamzerin.kata.bankaccount.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
