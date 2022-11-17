package com.systempro.authentication.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.systempro.authentication.entities.Client;
import com.systempro.authentication.repositories.ClientRepository;
import com.systempro.authentication.services.exceptions.ObjectNotFoundException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final ClientRepository repository;

	public UserDetailsServiceImpl(ClientRepository repository) {
		this.repository = repository;
	}

	// metodo responsavel por fazer a busca no banco de dados um usuario
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Client cli = repository.findByEmail(username).orElseThrow(() -> new ObjectNotFoundException("Email ou senha invalodos"));
		return cli;
	}

}
