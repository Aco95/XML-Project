package com.example.agent.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.agent.entities.Komentar;

@Repository
public interface KomentarRepository extends MongoRepository<Komentar, String>{

}
