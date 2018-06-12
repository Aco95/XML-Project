package com.example.agent.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.agent.entities.Korisnik;

@Repository
public interface KorisnikRepository extends MongoRepository<Korisnik, String>{

}
