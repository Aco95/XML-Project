package com.example.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.entities.Recenzija;

@Repository 
public interface RecenzijaRepository extends MongoRepository<Recenzija, String>{

}
