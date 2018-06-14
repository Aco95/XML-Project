package com.example.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.entities.Soba;

@Repository
public interface SobaRepository extends MongoRepository<Soba, String>{

}
