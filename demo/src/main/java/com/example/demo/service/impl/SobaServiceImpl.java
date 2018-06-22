package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Soba;
import com.example.demo.repository.SobaRepository;
import com.example.demo.service.ISobaService;

@Service
public class SobaServiceImpl implements ISobaService{

	@Autowired
	private SobaRepository sobaRepository;
	
	@Override
	public List<Soba> getAll() {
		// TODO Auto-generated method stub
		return sobaRepository.findAll();
	}

	@Override
	public Optional<Soba> getSobaById(String id) {
		// TODO Auto-generated method stub
		return sobaRepository.findById(id);
	}

	@Override
	public Soba updateSoba(Soba s) {
		// TODO Auto-generated method stub
		return sobaRepository.save(s);
	}

	@Override
	public String getSmestajID(String roomID) {
		Soba soba = sobaRepository.getSmestajID(roomID);
		
		return soba.getIdSmestaja();
	}

	
	
}
