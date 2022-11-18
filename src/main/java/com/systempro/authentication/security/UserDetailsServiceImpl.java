package com.systempro.authentication.security;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.systempro.authentication.entities.Users;
import com.systempro.authentication.repositories.UserRepository;
import com.systempro.authentication.services.exceptions.ObjectNotFoundException;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository repository;

	public UserDetailsServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	// metodo responsavel por fazer a busca no banco de dados um usuario
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users cli = repository.findByEmail(email)
				.orElseThrow(() -> new ObjectNotFoundException("Email ou senha invalodos"));
		return new UserRole(cli.getId(), cli.getEmail(), cli.getPassword(), cli.getPerfis());
	}

}
