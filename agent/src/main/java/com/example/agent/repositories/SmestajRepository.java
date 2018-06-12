package com.example.agent.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.agent.entities.Smestaj;

@Repository
public interface SmestajRepository extends MongoRepository<Smestaj, String>{

}
