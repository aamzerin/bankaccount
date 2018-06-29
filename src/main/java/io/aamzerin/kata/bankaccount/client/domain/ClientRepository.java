package io.aamzerin.kata.bankaccount.client.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface ClientRepository.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
