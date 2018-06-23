package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Recenzija;

public interface IRecenzijaService {

	void setRecenzija(Recenzija recenzija);
	Recenzija getRecenzijaById(String recenzijaId);
	List<Recenzija> findBySmestajAndRejting(String smestajId,int ocena);
	int calculateAverageRejtingForSmestaj(String smestajId);
	public List<Recenzija> findByNotAllowed(Boolean allowed) ;
	
}
