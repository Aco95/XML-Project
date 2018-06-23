package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Poruka;
import com.example.demo.repository.PorukaRepository;
import com.example.demo.service.IPorukaService;

@Service
public class PorukaServiceImpl implements IPorukaService{
	
	@Autowired
	private PorukaRepository porukaRepository;


	@Override
	public Poruka insertMessage(Poruka p) {
		
		return porukaRepository.insert(p);
	}


	@Override
	public List<Poruka> getByPrimljena(Boolean primljena) {
		// TODO Auto-generated method stub
		return porukaRepository.findByPrimljena(primljena);
	}

}
