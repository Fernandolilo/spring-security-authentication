package com.systempro.authentication.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.systempro.authentication.entities.Users;
import com.systempro.authentication.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public List<Users> findAll() {
		return repository.findAll();
	}

}
