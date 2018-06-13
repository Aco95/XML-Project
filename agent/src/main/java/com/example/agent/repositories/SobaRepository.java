package com.example.agent.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.agent.entities.Soba;

@Repository
public interface SobaRepository extends MongoRepository<Soba, String>{

}
