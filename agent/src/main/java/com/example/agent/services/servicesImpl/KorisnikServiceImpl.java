package com.example.agent.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agent.entities.Korisnik;
import com.example.agent.repositories.KorisnikRepository;
import com.example.agent.services.KorisnikService;

@Service
public class KorisnikServiceImpl implements KorisnikService {

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
}
