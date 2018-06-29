package io.aamzerin.kata.bankaccount.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.aamzerin.kata.bankaccount.client.domain.ClientRepository;

/**
 * The Class ClientService.
 */
@Service
public class ClientService {

	/** The client repository. */
	@Autowired
	ClientRepository clientRepository;

}
