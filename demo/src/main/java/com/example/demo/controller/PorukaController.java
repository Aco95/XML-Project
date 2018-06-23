package com.example.demo.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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

import com.example.demo.dto.PorukaDTO;
import com.example.demo.entities.Korisnik;
import com.example.demo.entities.Poruka;
import com.example.demo.service.IKorisnikService;
import com.example.demo.service.IPorukaService;


@RestController
@RequestMapping({"/public/messages"})
@CrossOrigin(origins = "*")
public class PorukaController {

	@Autowired
	private IPorukaService porukaService;
	
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
			value = "/sendMessage",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean sendMessage(@RequestBody PorukaDTO pDTO) {
			
		Poruka p = new Poruka();
		Korisnik klijent = korisnikService.getUserById(pDTO.getIdKlijenta()).get();
		Korisnik agent = korisnikService.getUserById(pDTO.getIdAgenta()).get();
		
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
		p.setProcitana(pDTO.isProcitana());
		p.setPrimljena(pDTO.isPrimljena());
		p.setSadrzaj(pDTO.getSadrzaj());
		p.setIdKlijenta(pDTO.getIdKlijenta());
		p.setIdAgenta(pDTO.getIdAgenta());
		
		
		try {
			porukaService.insertMessage(p);
			
			klijent.getPoslatePoruke().add(p);
			korisnikService.save(klijent);
			
			agent.getPrimljenePoruke().add(p);
			korisnikService.save(agent);
			
			return true;
			
		} catch (Exception e) {
			System.out.println("greska");
			return false;
		}
		
	   
	}
	
	
}
