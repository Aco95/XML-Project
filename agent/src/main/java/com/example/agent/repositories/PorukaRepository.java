package com.example.agent.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.agent.entities.Poruka;

@Repository
public interface PorukaRepository extends MongoRepository<Poruka, String> {

	List<Poruka> findByPrimljena(Boolean primljena);
}
