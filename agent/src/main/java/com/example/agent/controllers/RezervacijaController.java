package com.example.agent.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.agent.dtos.RezervacijaDTO;
import com.example.agent.entities.Korisnik;
import com.example.agent.entities.Realizacija;
import com.example.agent.entities.Rezervacija;
import com.example.agent.entities.Smestaj;
import com.example.agent.entities.Soba;
import com.example.agent.services.KorisnikService;
import com.example.agent.services.RezervacijaService;
import com.example.agent.services.SmestajService;
import com.example.agent.services.SobaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rezervacije")
public class RezervacijaController {

	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private SobaService sobaService;
	
	@Autowired
	private SmestajService smestajService;
	
	@RequestMapping(
			value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)

	public List<RezervacijaDTO> getRezervacije() {
		
		List<Rezervacija> rezervacije = rezervacijaService.getRezervacije();
		List<RezervacijaDTO> rezervacijeDTO = new ArrayList();
		
		//trenutno vreme	
		Date current = new Date();
		System.out.println("Trenutno vreme " + current);
		
		for (int i = 0; i < rezervacije.size(); i++) {
			
			Korisnik k = new Korisnik();
			Soba s = new Soba();
			RezervacijaDTO rDTO= new RezervacijaDTO();
			Smestaj sm = new Smestaj();
			
			rDTO.setId(rezervacije.get(i).getId());
			rDTO.setOd(rezervacije.get(i).getOd());
			rDTO.set_do(rezervacije.get(i).get_do());
			
			//da ne bih povukao na prikaz rezervacija one dane kada je agent zabranio rezervacije
			if (rezervacije.get(i).getIdKorisnika().equals("-1"))
				continue;
			
			k = korisnikService.getById(rezervacije.get(i).getIdKorisnika()).get();
			s = sobaService.getById(rezervacije.get(i).getIdSobe()).get();
			sm = smestajService.getById(s.getIdSmestaja()).get();
			
			rDTO.setKlijent(k);
			rDTO.setSoba(s);
			rDTO.setSmestaj(sm);
			
			//konverzija XMLGregorijana u Date da bih mogao da uporedim
			Date od = rezervacije.get(i).getOd().toGregorianCalendar().getTime();
			
			//prvi if sluzi da ne bih opet menjao one koje je agend vec markirao 
			if (rezervacije.get(i).getRealizacija() != Realizacija.REALIZED && rezervacije.get(i).getRealizacija() != Realizacija.UNREALIZED) {
			
				if(od.compareTo(current) >= 0){
					
					rDTO.setRealizacija(Realizacija.WAITING_TO_CHECK_IN);
					
	            } else {
	            	
	            	rDTO.setRealizacija(Realizacija.WAITING_TO_CONFIRM_REALIZATION);
	            	rezervacije.get(i).setRealizacija(Realizacija.WAITING_TO_CONFIRM_REALIZATION);
	            	
	            	//potrebno je ovu promenu odma sacuvati u bazu, jer jedino ovde proveravam dal je poceo boravak
	            	rezervacijaService.update(rezervacije.get(i));
	            }
			} else {
				
				rDTO.setRealizacija(rezervacije.get(i).getRealizacija());
				
			}
			
			
			
			
			rezervacijeDTO.add(rDTO);
		}
		
		return rezervacijeDTO;
		
	}
	
	@RequestMapping(value = "/changeRealizacija", method = RequestMethod.PUT)
	public @ResponseBody Rezervacija changeRealizacija(@RequestBody RezervacijaDTO rDTO){
	 
		Rezervacija r = new Rezervacija();
		r.setId(rDTO.getId());
		r.setIdKorisnika(rDTO.getKlijent().getId());
		r.setIdSobe(rDTO.getSoba().getId());
		r.setOd(rDTO.getOd());
		r.set_do(rDTO.get_do());
		r.setRealizacija(rDTO.getRealizacija());
		
		
		return rezervacijaService.update(r);
	}
}
