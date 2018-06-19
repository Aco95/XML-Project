package com.example.agent.services;

import java.util.List;

import com.example.agent.entities.Korisnik;


public interface KorisnikService {

	Korisnik getByUsername(String username);
	
	List<Korisnik> getAll();
}
