package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Recenzija;

@Repository 
public interface RecenzijaRepository extends MongoRepository<Recenzija, String>{

}
