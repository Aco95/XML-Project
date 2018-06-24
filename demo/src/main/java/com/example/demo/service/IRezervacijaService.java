package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Rezervacija;

public interface IRezervacijaService {
	
	Optional<Rezervacija> getReservationById(String id);
	Rezervacija addReservation(Rezervacija r);
	List<Rezervacija> getUserReservation(String userID);
	
	void deleteReservation(String reservationID);
	
	Rezervacija update(Rezervacija r);

}
