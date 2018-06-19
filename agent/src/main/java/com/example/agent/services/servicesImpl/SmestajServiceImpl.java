package com.example.agent.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agent.entities.Smestaj;
import com.example.agent.repositories.SmestajRepository;
import com.example.agent.services.SmestajService;

@Service
public class SmestajServiceImpl implements SmestajService {

	@Autowired
	private SmestajRepository smestajRepository;

	@Override
	public List<Smestaj> getSmestaji() {
		
		return smestajRepository.findAll();
	}

	@Override
	public Smestaj insertAccommodation(Smestaj s) {
		
		return smestajRepository.insert(s);
	}

	@Override
	public Optional<Smestaj> getById(String id) {
		
		return smestajRepository.findById(id);
	}
}
