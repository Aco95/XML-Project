package com.example.agent.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.agent.entities.Recenzija;

@Repository 
public interface RecenzijaRepository extends MongoRepository<Recenzija, String>{

}
