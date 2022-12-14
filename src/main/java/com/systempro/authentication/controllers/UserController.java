package com.systempro.authentication.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systempro.authentication.entities.Users;
import com.systempro.authentication.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping
	//libera apenas um ROLE especifico
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	
	// libera acesso a varios ROLES
	@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_USER')")
	public ResponseEntity<List<Users>> findAll() {
		List<Users> cli = service.findAll();
		return ResponseEntity.ok().body(cli);
	}
}
