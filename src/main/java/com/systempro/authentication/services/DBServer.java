package com.systempro.authentication.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.systempro.authentication.entities.Users;
import com.systempro.authentication.repositories.UserRepository;

@Service
public class DBServer {

	private final UserRepository repository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public DBServer(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.repository = repository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public void initializerDB() {

		Users cli = new Users(null, "Fernando da Silva", "12312312311", bCryptPasswordEncoder.encode("1234"),
				"fernando.silva@silva.com");
		System.out.println("Senha: " + cli.getPassword());
		repository.save(cli);
	}

}
