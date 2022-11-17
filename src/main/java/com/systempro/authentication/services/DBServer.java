package com.systempro.authentication.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.systempro.authentication.entities.Client;
import com.systempro.authentication.repositories.ClientRepository;

@Service
public class DBServer {

	private final ClientRepository repository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public DBServer(ClientRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.repository = repository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public void initializerDB() {

		Client cli = new Client(null, "Fernando da Silva", "12312312311", bCryptPasswordEncoder.encode("1234"),
				"fernando.silva@silva.com");
		System.out.println("Senha: " + cli.getPassword());
		repository.save(cli);
	}

}
