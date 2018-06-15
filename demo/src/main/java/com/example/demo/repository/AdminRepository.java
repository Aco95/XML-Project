package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Korisnik;

@Repository
public interface AdminRepository extends MongoRepository<Korisnik, String>{

}
