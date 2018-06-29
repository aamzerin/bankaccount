package io.aamzerin.kata.bankaccount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.aamzerin.kata.bankaccount.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;

}
