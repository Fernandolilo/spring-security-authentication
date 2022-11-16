package com.systempro.authentication.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systempro.authentication.entities.Client;
import com.systempro.authentication.services.ClientService;

@RestController
@RequestMapping(value = "/clientes")
public class ClientController {

	private final ClientService service;
	
	public ClientController(ClientService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> cli = service.findAll();
		return ResponseEntity.ok().body(cli);
	}
}
