package com.example.demo.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Korisnik;
import com.example.demo.repository.KorisnikRepository;

@RestController
@RequestMapping(value="/users")
@CrossOrigin(origins="http://localhost:4200")
public class KorisnikController {

	@RequestMapping(value="", method=RequestMethod.GET)
	public void pogodiMe() {
		System.out.println("Hvala dragom Bogu!");
	}
}
