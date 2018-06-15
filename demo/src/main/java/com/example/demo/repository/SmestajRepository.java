package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Smestaj;
import com.example.demo.entities.Tip;

@Repository
public interface SmestajRepository extends MongoRepository<Smestaj, String>{
	
	@Query("{'mesto' : ?0 }")
	List<Smestaj> findByMesto(String mesto);
	
	
	@Query("{'mesto': ?0 ,'kategorija' : ?1 ,'tip' : ?2 ,'parking' : ?3 ,'wifi' : ?4 ,"
			+ "'dorucak' : ?5 ,'polupansion' : ?6 ,'pansion' : ?7 ,'tv' : ?8 ,'miniKuhinja' : ?9 ,'privatnoKupatilo' : ?10 }")
	List<Smestaj> findByMoreAttributes(String mesto, Integer kategorija, Tip tip, Boolean parking,
			Boolean wifi, Boolean dorucak, Boolean polupansion, Boolean pansion, Boolean tv, Boolean miniKuhinja, Boolean privatnoKupatilo);
	

}
