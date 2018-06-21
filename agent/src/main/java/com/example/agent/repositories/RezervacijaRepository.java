package com.example.agent.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.agent.entities.Rezervacija;

public interface RezervacijaRepository extends MongoRepository<Rezervacija, String>{

}
