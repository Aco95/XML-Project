package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Korisnik;

@Repository
public interface KorisnikRepository extends MongoRepository<Korisnik, String> {
	
	@Query("{'email': ?0}")
	Optional<Korisnik> findOneByEmail(String email);
	
	Optional<Korisnik> findOneByUsername(String username);


}
