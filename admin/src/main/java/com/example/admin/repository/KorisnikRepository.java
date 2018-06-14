package com.example.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.entities.Korisnik;

@Repository
public interface KorisnikRepository extends MongoRepository<Korisnik, String>{

}
