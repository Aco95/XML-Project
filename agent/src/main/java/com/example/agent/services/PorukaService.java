package com.example.agent.services;

import java.util.List;

import com.example.agent.entities.Poruka;
import com.example.agent.entities.Smestaj;

public interface PorukaService {

	List<Poruka> getByPrimljena(Boolean primljena);
	
	Poruka insertMessage(Poruka p);
	
	Boolean deleteAll();
	
	Poruka deleteMessage(Poruka p);
	
	Poruka update(Poruka p);
}
