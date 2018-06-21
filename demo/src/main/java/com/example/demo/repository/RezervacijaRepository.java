package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entities.Rezervacija;

public interface RezervacijaRepository extends MongoRepository<Rezervacija, String>{
	
	@Query("{'idKorisnika' : ?0}")
	List<Rezervacija> findByIDKorisnika(String idKorisnika);

}
