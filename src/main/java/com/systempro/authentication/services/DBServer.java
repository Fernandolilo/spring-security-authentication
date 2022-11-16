package com.systempro.authentication.services;

import org.springframework.stereotype.Service;

import com.systempro.authentication.entities.Client;
import com.systempro.authentication.repositories.ClientRepository;

@Service
public class DBServer {

	private final ClientRepository repository;

	public DBServer(ClientRepository repository) {
		this.repository = repository;
	}

	public void initializerDB() {

		Client cli = new Client(null, "Fernando da Silva", "12312312311", "1234", "fernando.silva@silva.com");

		repository.save(cli);
	}

}
