package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Rezervacija;
import com.example.demo.repository.RezervacijaRepository;

@Service
public class RezervacijaServiceImpl implements IRezervacijaService{

	
	@Autowired
	private RezervacijaRepository rezervacijaRepository;
	
	@Override
	public Rezervacija addReservation(Rezervacija r) {
		// TODO Auto-generated method stub
		System.out.println("Usao u repositor - insert rezervacija");
		return rezervacijaRepository.insert(r);
	}

}
