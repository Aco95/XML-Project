package com.example.agent.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agent.entities.Korisnik;
import com.example.agent.repositories.KorisnikRepository;
import com.example.agent.services.IKorisnikService;

@Service
public class KorisnikServiceImpl implements IKorisnikService {

	@Autowired
	private KorisnikRepository korisnikRepository;

	@Override
	public Korisnik getByUsername(String username) {
		
		return korisnikRepository.findByUsername(username);
	}

	@Override
	public List<Korisnik> getAll() {
		
		return korisnikRepository.findAll();
	}

	@Override
	public Optional<Korisnik> getById(String id) {
		
		return korisnikRepository.findById(id);
	}

	@Override
	public Optional<Korisnik> getUserByEmail(String email) {
		Optional<Korisnik> korisnik =korisnikRepository.findOneByEmail(email);
		System.out.println("korisnik servis***");
		return korisnik;
	}

	@Override
	public Korisnik save(Korisnik korisnik) {
		
		return korisnikRepository.save(korisnik);
	}
}
