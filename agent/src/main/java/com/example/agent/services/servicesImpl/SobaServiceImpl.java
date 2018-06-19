package com.example.agent.services.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agent.entities.Soba;
import com.example.agent.repositories.SobaRepository;
import com.example.agent.services.SobaService;

@Service
public class SobaServiceImpl implements SobaService {

	@Autowired
	private SobaRepository sobaRepository;
	
	@Override
	public Optional<Soba> getById(String id) {
		
		return sobaRepository.findById(id);
	}

}
