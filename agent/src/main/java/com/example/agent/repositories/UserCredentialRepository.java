package com.example.agent.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.agent.entities.UserCredential;

public interface UserCredentialRepository extends MongoRepository<UserCredential, String>{
	Optional<UserCredential> findOneByEmail(String email);

}
