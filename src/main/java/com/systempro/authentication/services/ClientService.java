package com.systempro.authentication.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.systempro.authentication.entities.Client;
import com.systempro.authentication.repositories.ClientRepository;

@Service
public class ClientService {

	private final ClientRepository repository;

	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}

	public List<Client> findAll() {
		return repository.findAll();
	}

}
