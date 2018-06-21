package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Rezervacija;

public interface IRezervacijaService {
	
	Rezervacija addReservation(Rezervacija r);
	List<Rezervacija> getUserReservation(String userID);

}
