package com.example.demo.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.CurrentUser;
import com.example.demo.entities.Korisnik;


@RestController
@RequestMapping(value="/users")
@CrossOrigin(origins="http://localhost:4200")
public class KorisnikController {

	@RequestMapping(value="", method=RequestMethod.GET)
	public void pogodiMe() {
		System.out.println("Hvala dragom Bogu!");
	}
	  @RequestMapping(
	    		value = "/angularUser",
				method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
	    public Korisnik getUserPageAngular(@ModelAttribute("currentUser") CurrentUser currentUser) {
	    	System.out.println("treba da vrati:" +currentUser);
	        return currentUser.getUser();
	    }
}
