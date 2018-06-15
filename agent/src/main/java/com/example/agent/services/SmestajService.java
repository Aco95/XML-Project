package com.example.agent.services;


import java.util.List;

import com.example.agent.entities.Smestaj;

public interface SmestajService {

	List<Smestaj> getSmestaji();
	
	Smestaj insertAccommodation(Smestaj s);
}
