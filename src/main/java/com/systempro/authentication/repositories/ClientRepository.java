package com.systempro.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systempro.authentication.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
