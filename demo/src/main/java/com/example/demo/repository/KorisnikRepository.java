package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Korisnik;

public interface KorisnikRepository extends MongoRepository<Korisnik, String> {

}
