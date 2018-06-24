package com.example.demo.controller; 

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.CurrentUser;
import com.example.demo.entities.Korisnik;
import com.example.demo.entities.Poruka;
import com.example.demo.entities.Smestaj;
import com.example.demo.entities.Uloga;
import com.example.demo.service.IKorisnikService;
import com.example.demo.entities.Rezervacija;


@RestController
@RequestMapping("/users")
//@CrossOrigin(origins = "*")
@CrossOrigin(origins="http://localhost:4200")
public class KorisnikController {

	@Autowired
	private IKorisnikService korisnikService;
	
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
		String password = new BCryptPasswordEncoder().encode(user.getPassword());
		String jmbg = user.getMaticniBroj();
		String adresa = user.getAdresa();
		Uloga uloga = user.getUloga();
		String email = user.getEmail();
		boolean blokiran = user.isBlokiran();
		
		Korisnik regKorisnik = new Korisnik(new ArrayList<Smestaj>(), new ArrayList<Poruka>(), new ArrayList<Poruka>(), new ArrayList<Rezervacija>(),
											ime, prezime, uloga, email, username, password, jmbg, adresa, blokiran); 
		regKorisnik.setId(id);
		
		int size;
		if((size=korisnikService.count()) == 0) {
			size = 1;
		}
		else {
			size++;
			String ssize = Integer.toString(size);
			regKorisnik.setId(ssize);
		}
		
		System.out.println("Primljen email: "+user.getEmail());
		
		Optional<Korisnik> korisnik = korisnikService.getUserByEmail(email);
		
		if(!korisnik.isPresent()) {
			System.out.println("Ne postoji prethodno taj mejl u bazi");
			korisnikService.save(regKorisnik);
		}
		else {
			System.out.println("Vec postoji ovaj email");
			regKorisnik.setId("-1");
		}
				
		return new ResponseEntity<Object>(regKorisnik, HttpStatus.OK);
	}
	  @RequestMapping(
	    		value = "/angularUser",
				method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
	    public Korisnik getUserPageAngular(@ModelAttribute("currentUser") CurrentUser currentUser) {
	    	System.out.println("treba da vrati:" +currentUser);
	        return currentUser.getUser();
	    }
	  
	  
	  
	  @RequestMapping(
				value = "/getUserById/{id}",
				method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Korisnik getUserById(@PathVariable("id") String id){
			
		  	System.out.println("Id korisnika: " + id);
		  
			return korisnikService.getUserById(id).get();
			
		}
	  
	  
}
