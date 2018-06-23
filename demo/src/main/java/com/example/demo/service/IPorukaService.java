package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Poruka;

public interface IPorukaService {

	Poruka insertMessage(Poruka p);
	
	List<Poruka> getByPrimljena(Boolean primljena);
}
