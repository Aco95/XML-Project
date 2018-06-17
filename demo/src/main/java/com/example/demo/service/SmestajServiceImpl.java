package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Smestaj;
import com.example.demo.entities.Tip;
import com.example.demo.repository.SmestajRepository;

@Service
public class SmestajServiceImpl implements ISmestajService{

	
	@Autowired
	private SmestajRepository smestajRepository;
	
	@Override
	public List<Smestaj> getAll() {
		// TODO Auto-generated method stub
		return smestajRepository.findAll();
	}

	@Override
	public Optional<Smestaj> getSmestajById(String id) {
		// TODO Auto-generated method stub
		return smestajRepository.findById(id);
	}

	@Override
	public List<Smestaj> getSmestajbyMesto(String mesto) {
		// TODO Auto-generated method stub	
		return smestajRepository.findByMesto(mesto);
	}

	@Override
	public List<Smestaj> getSmestajbyMoreAttributes(String mesto, Integer kategorija, Tip tip, Boolean parking,
			Boolean wifi, Boolean dorucak, Boolean polupansion, Boolean pansion, Boolean tv, Boolean miniKuhinja,
			Boolean privatnoKupatilo) {
		// TODO Auto-generated method stub
		List<Smestaj> s = smestajRepository.findByMoreAttributes(mesto, kategorija, tip, parking, wifi, dorucak, polupansion, pansion, tv, miniKuhinja, privatnoKupatilo);
		
		System.out.println("broj iz servisa: " + s.size());
		
		return smestajRepository.findByMoreAttributes(mesto, kategorija, tip, parking, wifi, dorucak, polupansion, pansion, tv, miniKuhinja, privatnoKupatilo);
	}

}