package com.example.agent.controllers;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.agent.demoModel.AddMessageRequest;
import com.example.agent.demoModel.AddMessageResponse;
import com.example.agent.demoModel.AddSmestajRequest;
import com.example.agent.demoModel.AddSmestajResponse;
import com.example.agent.demoModel.DemoServicePort;
import com.example.agent.demoModel.DemoServicePortService;
import com.example.agent.demoModel.GetPorukeRequest;
import com.example.agent.demoModel.GetPorukeResponse;
import com.example.agent.dtos.PorukaDTO;
import com.example.agent.dtos.SmestajDTO;
import com.example.agent.entities.Korisnik;
import com.example.agent.entities.Poruka;
import com.example.agent.entities.Smestaj;
import com.example.agent.entities.Soba;
import com.example.agent.repositories.KorisnikRepository;
import com.example.agent.services.IKorisnikService;
import com.example.agent.services.PorukaService;
import com.example.agent.services.SmestajService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/poruke")
public class PorukaController {

	@Autowired
	private PorukaService porukaService;
	
	@Autowired
	private IKorisnikService korisnikService;
	
	@RequestMapping(
			value = "/getPrimljenePoruke", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)

	public List<Poruka> getPrimljenePoruke() {
		
		DemoServicePortService demoServicePortService = new DemoServicePortService();
		DemoServicePort port = demoServicePortService.getDemoServicePortSoap11();
		GetPorukeRequest getPorukeRequest = new GetPorukeRequest();
		getPorukeRequest.setId("1");
		GetPorukeResponse getPorukeResponse = port.getPoruke(getPorukeRequest);
		
		
		List<Poruka> porukeSaGlavnogBacka = new ArrayList<>();
		
		List<Poruka> primljene = porukaService.getByPrimljena(true);
		
		for (Poruka p : primljene) {
			
			porukaService.deleteMessage(p);
		}
		
		for (com.example.agent.demoModel.Poruka porukaDemo : getPorukeResponse.getPoruke()) {
			
			Poruka p = new Poruka();
			p.setId(porukaDemo.getId());
			p.setNaslov(porukaDemo.getNaslov());
			p.setSadrzaj(porukaDemo.getSadrzaj());
			p.setDatumSlanja(porukaDemo.getDatumSlanja());
			p.setPrimljena(true);
			p.setProcitana(false);
			Korisnik sagovornik = korisnikService.getById(porukaDemo.getIdKlijenta()).get();
			p.setSagovornik(sagovornik);
			
			
			porukaService.update(p);
		}
		
		return porukaService.getByPrimljena(true);
	}
	
	@RequestMapping(
			value = "/getPoslatePoruke", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)

	public List<Poruka> getPoslatePoruke() {
		
		return porukaService.getByPrimljena(false);
		
	}
	
	@RequestMapping(
			value = "/send",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Poruka sendMessage(@RequestBody PorukaDTO pDTO) {
			
		Poruka p = new Poruka();
		Korisnik k = korisnikService.getByUsername(pDTO.getSagovornik());
		
		GregorianCalendar gcal = new GregorianCalendar();
	    XMLGregorianCalendar xgcal;
		try {
			xgcal = DatatypeFactory.newInstance()
			        .newXMLGregorianCalendar(gcal);
			 p.setDatumSlanja(xgcal);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		p.setId(Calendar.getInstance().getTimeInMillis() + "");
		p.setNaslov(pDTO.getNaslov());
		p.setProcitana(pDTO.getProcitana());
		p.setPrimljena(pDTO.getPrimljena());
		p.setSadrzaj(pDTO.getSadrzaj());
		p.setSagovornik(k);
	   
	    com.example.agent.demoModel.Poruka pDemo = new com.example.agent.demoModel.Poruka();
	    pDemo.setId(p.getId());
	    pDemo.setNaslov(p.getNaslov());
	    pDemo.setPrimljena(false);
	    pDemo.setProcitana(false);
	    pDemo.setDatumSlanja(p.getDatumSlanja());
	    pDemo.setSadrzaj(p.getSadrzaj());
	    pDemo.setIdKlijenta(p.getSagovornik().getId());
	    pDemo.setIdAgenta("1");
	    
	    
		//provera konekcije jer aplikacija treba da radi i u offline rezimu
		Socket sock = new Socket();
		InetSocketAddress addr = new InetSocketAddress("www.google.com", 80);
		
		try {
			
			sock.connect(addr);
			
			
			
			
			
		} catch (Exception e) {
		
			System.out.println("NEMA NETA");
			
			Poruka poruka = new Poruka();
			poruka.setSadrzaj("noInternetConnection");
			return poruka;
			
		} finally {
			
			try {
				
				sock.close();
				
			} catch (Exception e) {
				
				System.out.println("Greska pri zatvaranju konekcije");
			}
			
		}
		
		System.out.println("IMA NETA");
		
		p = porukaService.insertMessage(p);
		
		if (p != null) {
			
			
			DemoServicePortService demoServicePortService = new DemoServicePortService();
			DemoServicePort port = demoServicePortService.getDemoServicePortSoap11();
			AddMessageRequest addMessageRequest = new AddMessageRequest();
			addMessageRequest.setPoruka(pDemo);
			AddMessageResponse addMessageResponse = port.addMessage(addMessageRequest);
			System.out.println("U glavnu bazu upisana poruka: " + addMessageResponse.getPoruka().getNaslov());
			return p;
			
		} else {
			
			return null;
		}
					
	}
}
