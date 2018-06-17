package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Korisnik;
import com.example.demo.repository.KorisnikRepository;

@Service
public class KorisnikServiceImp implements IKorisnikService{
	
	@Autowired
	KorisnikRepository korisnikRepository;

	@Override
	public Korisnik findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Korisnik> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Korisnik save(Korisnik korisnik) {
		// TODO Auto-generated method stub
		return korisnikRepository.save(korisnik);
	}

	@Override
	public List<Korisnik> saveAll(List<Korisnik> korisnici) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Korisnik delete(Korisnik korisnik) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(List<String> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Korisnik findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
