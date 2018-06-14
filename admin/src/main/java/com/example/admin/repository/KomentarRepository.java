package com.example.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.entities.Komentar;

@Repository
public interface KomentarRepository extends MongoRepository<Komentar, String>{

}
