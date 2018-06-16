package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Korisnik;

public interface IKorisnikService {
	Korisnik findOne(String id);
	List<Korisnik> findAll();
	Korisnik save(Korisnik korisnik);
	List<Korisnik> saveAll(List<Korisnik> korisnici);
	Korisnik delete(Korisnik korisnik);
	void delete(List<String> ids);
	Korisnik findByUsername(String username);

}
