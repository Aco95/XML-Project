package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Komentar;

@Repository
public interface KomentarRepository extends MongoRepository<Komentar, String>{

}
