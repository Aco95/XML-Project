package com.example.demo.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Korisnik;
import com.example.demo.entities.Uloga;
import com.example.demo.service.IKorisnikService;


@RestController
@RequestMapping(value="/users")
@CrossOrigin(origins="http://localhost:4200")
public class KorisnikController {

	/*
	@RequestMapping(value="", method=RequestMethod.GET)
	public void pogodiMe() {
		System.out.println("Hvala dragom Bogu!");
	}
	*/
	@RequestMapping(value="", method=RequestMethod.GET)
	public void nasaoSamTe() {
		System.out.println("Nasao sam te!");
	}
	
	
	private IKorisnikService korisnikService;
	
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public ResponseEntity<Object> test() {
		System.out.println("Test hello");
		//String data = "Boban Hello";
		int data = 3;
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	
	
	
	//registracije
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ResponseEntity<Object> registerUser(@RequestBody Korisnik user) {
		System.out.println("Registracija pocela");
		
		String id = user.getId();
		String ime = user.getIme();
		String prezime = user.getPrezime();
		String username = user.getUsername();
		String password = user.getPassword();
		String jmbg = user.getMaticniBroj();
		String adresa = user.getAdresa();
		Uloga uloga = user.getUloga();
		boolean blokiran = user.isBlokiran();
		
		Korisnik regKorisnik = new Korisnik(id, ime, prezime, uloga, username, password, jmbg, adresa); 
		
		System.out.println(regKorisnik.getId()+" "+regKorisnik.getUsername() );
		
		//korisnikService.save(regKorisnik);
		
		int i = 3;
		
		return new ResponseEntity<Object>(regKorisnik, HttpStatus.OK);
	}
}
