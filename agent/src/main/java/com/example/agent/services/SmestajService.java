package com.example.agent.services;


import java.util.List;
import java.util.Optional;

import com.example.agent.entities.Smestaj;


public interface SmestajService {

	List<Smestaj> getSmestaji();
	
	Smestaj insertAccommodation(Smestaj s);
	
	Optional<Smestaj> getById(String id);
	
	Smestaj update(Smestaj s);
}
