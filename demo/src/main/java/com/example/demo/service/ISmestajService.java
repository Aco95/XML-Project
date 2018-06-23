package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Smestaj;
import com.example.demo.entities.Tip;

public interface ISmestajService {
	
	List<Smestaj> getAll();
	
	Optional<Smestaj> getSmestajById(String id);
	
	List<Smestaj> getSmestajbyMesto(String mesto);
	
	List<Smestaj> getSmestajbyMoreAttributes(String mesto, Integer kategorija, Tip tip, Boolean parking,
			Boolean wifi, Boolean dorucak, Boolean polupansion, Boolean pansion, Boolean tv, Boolean miniKuhinja, Boolean privatnoKupatilo);
	
	Smestaj saveEditedSmestaj(Smestaj s);
	
	void deleteSmestaj (Smestaj s);
	
	List<Smestaj> getSmestajbyRejting(double ocena);

}
