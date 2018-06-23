package com.example.agent.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.agent.entities.Korisnik; 

public interface UserRepository extends MongoRepository<Korisnik, String> {
	Optional<Korisnik> findOneByEmail(String email);
}
