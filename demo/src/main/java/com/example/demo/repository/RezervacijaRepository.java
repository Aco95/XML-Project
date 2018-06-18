package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Rezervacija;

public interface RezervacijaRepository extends MongoRepository<Rezervacija, String>{

}
