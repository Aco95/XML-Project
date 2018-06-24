package com.example.agent.services;

import java.util.List;
import java.util.Optional;

import com.example.agent.entities.Korisnik;


public interface IKorisnikService {

	Korisnik getByUsername(String username);
	
	Optional<Korisnik> getById(String id);
	
	List<Korisnik> getAll();
	
	Optional<Korisnik> getUserByEmail(String email);

}
