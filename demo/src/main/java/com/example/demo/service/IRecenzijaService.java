package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Recenzija;

public interface IRecenzijaService {

	void setRecenzija(Recenzija recenzija);
	Recenzija getRecenzijaById(String recenzijaId);
	List<String> findByRejting(int prosecanRejting);
	int calculateAverageRejtingForSmestaj(String smestajId);
}
