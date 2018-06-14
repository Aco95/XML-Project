package com.example.agent.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.agent.services.SmestajService;

import com.example.agent.entities.Smestaj;
import java.util.List;

import org.springframework.http.MediaType;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/smestaji")
public class SmestajController {

	@Autowired
	private SmestajService smestajService;
	
	
	@RequestMapping(
			value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)

	public List<Smestaj> getSmestaji() {
		
		return smestajService.getSmestaji();
		
	}
	
}
