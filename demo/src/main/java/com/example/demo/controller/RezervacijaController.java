package com.example.demo.controller;

import java.util.Calendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RezervacijaDTO;
import com.example.demo.entities.Korisnik;
import com.example.demo.entities.Rezervacija;
import com.example.demo.entities.Soba;
import com.example.demo.service.IKorisnikService;
import com.example.demo.service.IRezervacijaService;
import com.example.demo.service.ISobaService;

@RestController
@RequestMapping("/public/reservations")
@CrossOrigin(origins = "*")
public class RezervacijaController {
	
	@Autowired
	private ISobaService sobaService;
	
	@Autowired
	private IRezervacijaService rezervacijaService;
	
	@Autowired
	private IKorisnikService korisnikService;
	
	
	@RequestMapping(
			value = "/addReservation",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean addReservation(@RequestBody RezervacijaDTO r) throws DatatypeConfigurationException {
		
		
		System.out.println("Pogodioo");
		Rezervacija rezervacija = new Rezervacija();
		rezervacija.setId(Calendar.getInstance().getTimeInMillis()+"");
		rezervacija.setIdSobe(r.getRoom_id());
		rezervacija.setIdKorisnika(r.getUser_id());
		rezervacija.setOd(DatatypeFactory.newInstance().newXMLGregorianCalendar(r.getDateFrom()));
		rezervacija.setDo(DatatypeFactory.newInstance().newXMLGregorianCalendar(r.getDateTo()));
		
		rezervacijaService.addReservation(rezervacija);
		
		Soba soba = sobaService.getSobaById(r.getRoom_id()).get();
		soba.getRezervacije().add(rezervacija);
		sobaService.updateSoba(soba);
		
		Korisnik korisnik = korisnikService.getUserById(r.getUser_id()).get();
		korisnik.getRezervacije().add(rezervacija);
		korisnikService.save(korisnik);
		
		return true;
		
	}

}
