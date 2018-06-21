package com.example.agent.services;

import java.util.List;

import com.example.agent.entities.Rezervacija;
import com.example.agent.entities.Soba;



public interface RezervacijaService {

	List<Rezervacija> getRezervacije();
	
	Rezervacija update(Rezervacija r);
	
	Rezervacija insertRezervacija(Rezervacija r);
	
}
