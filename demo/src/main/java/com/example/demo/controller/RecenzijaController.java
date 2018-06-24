package com.example.demo.controller;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.CurrentUser;
import com.example.demo.entities.Komentar;
import com.example.demo.entities.Recenzija;
import com.example.demo.service.IRecenzijaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/recenzijaOffline"})
public class RecenzijaController {
	
	@Autowired
	private IRecenzijaService recenzijaService;
	
	@GetMapping
	public List<Recenzija> getComments(){														
		System.out.println("DEBUG::PRONALAZI RECENZIJE");
		return recenzijaService.findAll();	
	}
	
	@RequestMapping(
    		value = "/postRecenzija",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Recenzija createRecenzija(@RequestBody Recenzija rec, @ModelAttribute("currentUser") CurrentUser currentUser){
		System.out.println("DEBUG::ULAZI U KREIRANJE RECENZIJE.");
		Date danas = new Date();
		XMLGregorianCalendar datum = null;
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(danas);
		try {
			XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
			datum = xgc;
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Komentar k = new Komentar();
		k.setOdobren(false);
		k.setSadrzaj(rec.getKomentar().getSadrzaj());
		k.setDatum(datum);
		k.setId(danas.toString());
		
		Recenzija s = new Recenzija();
		s.setId(danas.toString());
		s.setKomentar(k);
		s.setOcena(rec.getOcena());
		s.setSmestajId(rec.getSmestajId());				
		
		s.setKorisnik(s.getKorisnik());
		
		recenzijaService.save(s);
		return rec;
	}
}
