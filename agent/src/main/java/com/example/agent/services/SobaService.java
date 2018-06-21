package com.example.agent.services;

import java.util.Optional;

import com.example.agent.entities.Soba;

public interface SobaService {

	Optional<Soba> getById(String id);
	
	Soba insertSoba(Soba s);
	
	Soba update(Soba s);
}
