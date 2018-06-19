package com.example.agent.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agent.entities.Poruka;
import com.example.agent.repositories.PorukaRepository;
import com.example.agent.services.PorukaService;

@Service
public class PorukaServiceImpl implements PorukaService{

	@Autowired
	private PorukaRepository porukaRepository;

	@Override
	public List<Poruka> getByPrimljena(Boolean primljena) {
		
		return porukaRepository.findByPrimljena(primljena);
	}

	@Override
	public Poruka insertMessage(Poruka p) {
		
		return porukaRepository.insert(p);
	}

	
}
