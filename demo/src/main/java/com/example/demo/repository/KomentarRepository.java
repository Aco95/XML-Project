package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Komentar;

@Repository
public interface KomentarRepository extends MongoRepository<Komentar, String>{
	
	@Query("{'odobren' : ?0}")
	List<Komentar> findByOdobren(Boolean odobren);
	
}
