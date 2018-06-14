package com.example.agent.services.servicesImpl;

import java.util.List;

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
}
