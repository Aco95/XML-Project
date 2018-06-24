package com.example.agent.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.agent.entities.Korisnik;

@Repository
public interface KorisnikRepository extends MongoRepository<Korisnik, String>{
	Optional<Korisnik> findOneByEmail(String email);

	Korisnik findByUsername(String username);
	
}
