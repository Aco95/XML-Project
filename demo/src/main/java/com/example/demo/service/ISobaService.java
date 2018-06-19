package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Soba;

public interface ISobaService {
	
	List<Soba> getAll();
	
	Optional<Soba> getSobaById(String id);
	
	Soba updateSoba(Soba s);

}
