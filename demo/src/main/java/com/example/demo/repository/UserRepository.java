package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.entities.Korisnik; 

public interface UserRepository extends MongoRepository<Korisnik, String> {
	Optional<Korisnik> findOneByEmail(String email);
}
