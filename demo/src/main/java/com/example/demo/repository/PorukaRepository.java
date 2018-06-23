package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Poruka;


@Repository
public interface PorukaRepository extends MongoRepository<Poruka, String> {
	
	@Query("{'idKlijenta' : ?0}")
	List<Poruka> findByIdKlijenta(String idKlijenta);
	
	@Query("{'idKlijenta' : ?0, 'idAgenta' : ?1}")
	List<Poruka> findByIdKlijentaAndIdAgenta(String idKlijenta, String IdAgenta);
	
	List<Poruka> findByPrimljena(Boolean primljena);


}
