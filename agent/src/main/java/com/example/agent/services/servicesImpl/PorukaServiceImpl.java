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

	@Override
	public Boolean deleteAll() {
		
		porukaRepository.deleteAll();
		
		return true;
	}

	@Override
	public Poruka deleteMessage(Poruka p) {
		
		porukaRepository.delete(p);
		
		return p;
	}

	@Override
	public Poruka update(Poruka p) {
		
		return porukaRepository.save(p);
	}

	
}
