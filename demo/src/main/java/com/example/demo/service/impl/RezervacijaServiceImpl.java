package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Rezervacija;
import com.example.demo.repository.RezervacijaRepository;
import com.example.demo.service.IRezervacijaService;

@Service
public class RezervacijaServiceImpl implements IRezervacijaService{

	
	@Autowired
	private RezervacijaRepository rezervacijaRepository;
	
	
	@Override
	public Optional<Rezervacija> getReservationById(String id) {
		// TODO Auto-generated method stub
		System.out.println("Upao ovde");
		return rezervacijaRepository.findById(id);
	}
	
	
	@Override
	public Rezervacija addReservation(Rezervacija r) {
		// TODO Auto-generated method stub
		System.out.println("Usao u repositor - insert rezervacija");
		return rezervacijaRepository.insert(r);
	}

	@Override
	public List<Rezervacija> getUserReservation(String userID) {
		// TODO Auto-generated method stub
		
		return rezervacijaRepository.findByIDKorisnika(userID);
	}

	@Override
	public void deleteReservation(String reservationID) {
		// TODO Auto-generated method stub
		rezervacijaRepository.deleteById(reservationID);
		
	}



}
