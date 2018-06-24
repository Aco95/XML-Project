package com.example.demo.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.CurrentUser;
import com.example.demo.entities.Komentar;
import com.example.demo.entities.Recenzija;
import com.example.demo.service.IRecenzijaService;
import com.example.demo.service.ISmestajService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/recenzijaOffline"})
public class RecenzijaController {
	
	@Autowired
	private IRecenzijaService recenzijaService;
	
	@Autowired
	private ISmestajService smestajService;
	
	@GetMapping
	public List<Recenzija> getComments(){														
		System.out.println("DEBUG::PRONALAZI RECENZIJE");
		return recenzijaService.findAll();	
	}
	
	@RequestMapping(value="/getNotAllowed", method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Recenzija> getNotAllowed(){
		//return recenzijaService.findByNotAllowed(false);
		List<Recenzija> ret = new ArrayList<Recenzija>();
		List<Recenzija> all = recenzijaService.findAll();
		for (Recenzija r: all){
			if(!r.getKomentar().isOdobren()){
				ret.add(r);
			}
		}
		return ret;
	}
	
	@PutMapping
	public void allowComemnt(@RequestBody Recenzija r){
		//commentService.findCommentById(k.getId()).get().setOdobren(true);
		System.out.println("ULAZI U MENJANJE KOMENTARA");
		r.getKomentar().setOdobren(true);
		recenzijaService.save(r);
		//recenzijaService.setRecenzija(r);
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
		//recenzijaService.setRecenzija(recenzija);
		//double avg = recenzijaService.calculateAverageRejtingForSmestaj(s.getSmestajId);
		//avg = Math.round(avg * 100.0)/100.0
		//smestajService.getSmestajById(s.getSmestajId()).get().setOcena(avg);
		//smestajService.insertAccommodation(smestajService.getSmestajById(s.getSmestajId()).get());
		
		return rec;
	}
}
