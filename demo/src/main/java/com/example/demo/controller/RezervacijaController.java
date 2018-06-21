package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(value="/get-user-reservation", method=RequestMethod.POST)
	public ResponseEntity<Object> getUserReservation(@RequestBody String id) {
		System.out.println("Prosledjen id: "+id );
		List<Rezervacija> ss = rezervacijaService.getUserReservation(id);
		
		return new ResponseEntity<Object>(ss, HttpStatus.OK);
	}
	
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
		rezervacija.setidKorisnika(r.getUser_id());
		rezervacija.setOd(DatatypeFactory.newInstance().newXMLGregorianCalendar(r.getDateFrom()));
		rezervacija.setDo(DatatypeFactory.newInstance().newXMLGregorianCalendar(r.getDateTo()));
		
		rezervacijaService.addReservation(rezervacija);
		
		Soba soba = sobaService.getSobaById(r.getRoom_id()).get();
		soba.getRezervacija().add(rezervacija);
		sobaService.updateSoba(soba);
		
		Korisnik korisnik = korisnikService.getUserById(r.getUser_id()).get();
		korisnik.getRezervacija().add(rezervacija);
		korisnikService.save(korisnik);
		
		return true;
		
	}

}
