package com.example.agent.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agent.entities.Rezervacija;
import com.example.agent.repositories.RezervacijaRepository;
import com.example.agent.services.RezervacijaService;

@Service
public class RezervacijaServiceImpl implements RezervacijaService {

	@Autowired
	private RezervacijaRepository rezervacijaRepository;

	@Override
	public List<Rezervacija> getRezervacije() {
		
		return rezervacijaRepository.findAll();
	}
}
