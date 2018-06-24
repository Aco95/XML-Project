package com.example.agent.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.agent.demoModel.AddSmestajRequest;
import com.example.agent.demoModel.AddSmestajResponse;
import com.example.agent.demoModel.DemoServicePort;
import com.example.agent.demoModel.DemoServicePortService;
import com.example.agent.demoModel.GetSobaRequest;
import com.example.agent.demoModel.GetSobaResponse;
import com.example.agent.dtos.RezervacijaDTO;
import com.example.agent.dtos.SobaDTO;
import com.example.agent.entities.CurrentUser;
import com.example.agent.entities.Rezervacija;
import com.example.agent.entities.Smestaj;
import com.example.agent.entities.Soba;
import com.example.agent.repositories.SobaRepository;
import com.example.agent.services.RezervacijaService;
import com.example.agent.services.SmestajService;
import com.example.agent.services.SobaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sobe")
public class SobaController {

	
	@Autowired
	private SobaService sobaService;
	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	@Autowired
	private SmestajService smestajService;
	
	@RequestMapping(value = "/changeSobaSchedule", method = RequestMethod.PUT)
	public @ResponseBody Boolean changeSobaSchedule(@RequestBody SobaDTO sDTO, @ModelAttribute("currentUser") CurrentUser currentUser) throws DatatypeConfigurationException{
	 
		System.out.println("Poslato: " + sDTO.getFrom());
		System.out.println("Poslato: " + sDTO.getTo());
		
		boolean vecRezervisano = false;
		XMLGregorianCalendar from = DatatypeFactory.newInstance().newXMLGregorianCalendar(sDTO.getFrom());
		XMLGregorianCalendar to = DatatypeFactory.newInstance().newXMLGregorianCalendar(sDTO.getTo());
		
		for (Rezervacija r : sDTO.getSoba().getRezervacije()) {
			
			vecRezervisano = isBetween(from, r.getOd(), r.get_do());
			
			if (vecRezervisano)
				break;
			
			vecRezervisano = isBetween(to, r.getOd(), r.get_do());
			
			if (vecRezervisano)
				break;
		}
		
		if (vecRezervisano) 
			
			return false;
		
		else {
			
			Soba s = sobaService.getById(sDTO.getSoba().getId()).get();
			Smestaj sm = smestajService.getById(s.getIdSmestaja()).get();
			
			
			Rezervacija r = new Rezervacija();
			r.setId(Calendar.getInstance().getTimeInMillis() + "");
			r.setIdSobe(s.getId());
			r.setIdKorisnika("-1");
			r.setOd(from);
			r.set_do(to);
			
			s.getRezervacije().add(r);
			
			List<Soba> promenjenaLista = new ArrayList<Soba>();
			for (Soba soba : sm.getSobe()) {
				
				if (soba.getId().equals(s.getId())) {
					
					promenjenaLista.add(s);
					continue;
				}
				
				promenjenaLista.add(soba);
			}
			
			sm.setSobe(promenjenaLista);
			rezervacijaService.insertRezervacija(r);
			
			sobaService.update(s);
			smestajService.update(sm);
			
			
			return true;
		}
		
		
			
		
		
	}
	
	
	public boolean isBetween(XMLGregorianCalendar date,
	        XMLGregorianCalendar start, XMLGregorianCalendar end) {
	    return (date.compare(start) == DatatypeConstants.GREATER || date
	            .compare(start) == DatatypeConstants.EQUAL)
	            && (date.compare(end) == DatatypeConstants.LESSER || date
	                    .compare(end) == DatatypeConstants.EQUAL);
	}
}
