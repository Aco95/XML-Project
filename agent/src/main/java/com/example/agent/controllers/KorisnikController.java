package com.example.agent.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.agent.entities.Korisnik;
import com.example.agent.services.KorisnikService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/korisnici")
public class KorisnikController {

	@Autowired
	private KorisnikService korisnikService;
	
	@RequestMapping(
			value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)

	public List<Korisnik> getKorisnici() {
		
		return korisnikService.getAll();
		
	}
	
	
}
