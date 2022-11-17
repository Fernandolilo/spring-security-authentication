package com.systempro.authentication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systempro.authentication.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	//response find to email
	Optional<Client> findByEmail(String email);
}
