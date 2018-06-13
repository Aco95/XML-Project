package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Smestaj;

@Repository
public interface SmestajRepository extends MongoRepository<Smestaj, String>{
	
	@Query(value = "{mesto:?0}")
	List<Smestaj> findByPlace(String mesto);

}
