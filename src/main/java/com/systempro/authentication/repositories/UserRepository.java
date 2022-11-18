package com.systempro.authentication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systempro.authentication.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	//response find to email
	Optional<Users> findByEmail(String email);
}
