package com.example.agent.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.agent.dtos.PorukaDTO;
import com.example.agent.dtos.SmestajDTO;
import com.example.agent.entities.Korisnik;
import com.example.agent.entities.Poruka;
import com.example.agent.entities.Smestaj;
import com.example.agent.entities.Soba;
import com.example.agent.repositories.KorisnikRepository;
import com.example.agent.services.IKorisnikService;
import com.example.agent.services.PorukaService;
import com.example.agent.services.SmestajService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/poruke")
public class PorukaController {

	@Autowired
	private PorukaService porukaService;
	
	@Autowired
	private IKorisnikService korisnikService;
	
	@RequestMapping(
			value = "/getPrimljenePoruke", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)

	public List<Poruka> getPrimljenePoruke() {
		
		return porukaService.getByPrimljena(true);
		
	}
	
	@RequestMapping(
			value = "/getPoslatePoruke", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)

	public List<Poruka> getPoslatePoruke() {
		
		return porukaService.getByPrimljena(false);
		
	}
	
	@RequestMapping(
			value = "/send",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Poruka sendMessage(@RequestBody PorukaDTO pDTO) {
			
		Poruka p = new Poruka();
		Korisnik k = korisnikService.getByUsername(pDTO.getSagovornik());
		
		GregorianCalendar gcal = new GregorianCalendar();
	    XMLGregorianCalendar xgcal;
		try {
			xgcal = DatatypeFactory.newInstance()
			        .newXMLGregorianCalendar(gcal);
			 p.setDatumSlanja(xgcal);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		p.setId(Calendar.getInstance().getTimeInMillis() + "");
		p.setNaslov(pDTO.getNaslov());
		p.setProcitana(pDTO.getProcitana());
		p.setPrimljena(pDTO.getPrimljena());
		p.setSadrzaj(pDTO.getSadrzaj());
		p.setSagovornik(k);
	   
	      
		return porukaService.insertMessage(p);
			
	}
}
