package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RezervacijaDTO;
import com.example.demo.entities.Korisnik;
import com.example.demo.entities.Realizacija;
import com.example.demo.entities.Rezervacija;
import com.example.demo.entities.Smestaj;
import com.example.demo.entities.Soba;
import com.example.demo.entities.Uloga;
import com.example.demo.service.IKorisnikService;
import com.example.demo.service.IRezervacijaService;
import com.example.demo.service.ISmestajService;
import com.example.demo.service.ISobaService;

@RestController
@RequestMapping("/public/reservations")
@CrossOrigin(origins = "*")
public class RezervacijaController {
	
	@Autowired
	private ISobaService sobaService;
	
	@Autowired
	private ISmestajService smestajService;
	
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
	
	@RequestMapping(value="/get-user-reservation-active/{userId}", method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Rezervacija> getUserReservationActive(@PathVariable("userId") String id){
		List<Rezervacija> ss = rezervacijaService.getUserReservation(id);
		List<Rezervacija> retVal = new ArrayList<Rezervacija>(); 
		Date today = new Date();
		
		for(Rezervacija rz: ss){
			Date rez_do = rz.getDo().toGregorianCalendar().getTime();
			if(today.before(rez_do)){
				retVal.add(rz);
			}
		}						
		return retVal;
	}
	
	@RequestMapping(value="/get-user-reservation-passed/{userId}", method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Rezervacija> getUserReservationPassed(@PathVariable("userId")String id){
		List<Rezervacija> ss = rezervacijaService.getUserReservation(id);
		List<Rezervacija> retVal = new ArrayList<Rezervacija>(); 
		Date today = new Date();
		
		for(Rezervacija rz: ss){
			Date rez_do = rz.getDo().toGregorianCalendar().getTime();
			if(today.after(rez_do)){
				retVal.add(rz);
			}
		}						
		return retVal;
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
		rezervacija.setIdKorisnika(r.getUser_id());
		rezervacija.setOd(DatatypeFactory.newInstance().newXMLGregorianCalendar(r.getDateFrom()));
		rezervacija.setDo(DatatypeFactory.newInstance().newXMLGregorianCalendar(r.getDateTo()));
		rezervacija.setRealizacija(Realizacija.WAITING_TO_CHECK_IN);
		
		rezervacijaService.addReservation(rezervacija);
		
		Soba soba = sobaService.getSobaById(rezervacija.getIdSobe()).get();
		System.out.println("SEKUND PRED UPDATE " + rezervacija.getIdSobe());
		soba.getRezervacije().add(rezervacija);
		sobaService.updateSoba(soba);
		
		Smestaj smestaj = smestajService.getSmestajById(soba.getIdSmestaja()).get();
		
		int indexSobe = 0;
		for (int i = 0; i < smestaj.getSobe().size(); i++) {
			
			if (smestaj.getSobe().get(i).getId().equals(soba.getId())) {
				
				indexSobe = i;
				break;
			}
		}
		
		smestaj.getSobe().set(indexSobe, soba);
		smestajService.saveEditedSmestaj(smestaj);
		
		Korisnik korisnik = korisnikService.getUserById(r.getUser_id()).get();
		korisnik.getRezervacije().add(rezervacija);
		korisnikService.save(korisnik);
		
		return true;
		
	}
	
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(
			value = "/deleteReservation/{reservationID}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Rezervacija> deleteReservation(@PathVariable("reservationID") String reservationID) {
		
		System.out.println("id rezervacije: " + reservationID);
		System.out.println(reservationID.substring(1, reservationID.length()-1));
		
		Rezervacija rezervacija = rezervacijaService.getReservationById(reservationID.substring(1, reservationID.length()-1)).get();
		
		rezervacijaService.deleteReservation(rezervacija.getId());
		
		Soba soba = sobaService.getSobaById(rezervacija.getIdSobe()).get();
		soba.getRezervacije().remove(rezervacija);
		sobaService.updateSoba(soba);
		
		Korisnik korisnik = korisnikService.getUserById(rezervacija.getIdKorisnika()).get();
		korisnik.getRezervacije().remove(rezervacija);
		korisnikService.save(korisnik);
		
//		return korisnik.getRezervacije();
		return rezervacijaService.getUserReservation(rezervacija.getIdKorisnika());
		
		
	}

	
	 @RequestMapping(
				value = "/getUserById/{id}",
				method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Korisnik getUserById(@PathVariable("id") String id){
			
		  	System.out.println("Id korisnika: " + id);
		  
			return korisnikService.getUserById(id.substring(1, id.length()-1)).get();
			
		}
	 
	 
	 @RequestMapping(
				value = "/getUserByUsername/{username}",
				method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Korisnik getUserByUsername(@PathVariable("username") String username){
			
		  	System.out.println(username);
		  
			return korisnikService.getUserByUsername(username.substring(1, username.length()-1)).get();
			
		}
	 
	 @RequestMapping(
				value = "/getAgenti",
				method = RequestMethod.GET, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Korisnik> getAgenti(){
			
			List<Korisnik> korisnici = korisnikService.findAll();
			List<Korisnik> agenti = new ArrayList<Korisnik>();
			
			for(Korisnik k : korisnici) {
				if(k.getUloga() == Uloga.AGENT) {
					agenti.add(k);
				}
			}
			
			return agenti;
		}
	 
}
