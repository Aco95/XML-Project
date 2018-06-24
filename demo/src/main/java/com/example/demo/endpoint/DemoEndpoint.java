package com.example.demo.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.entities.Rezervacija;
import com.example.demo.entities.AddMessageRequest;
import com.example.demo.entities.AddMessageResponse;
import com.example.demo.entities.AddRezervacijaRequest;
import com.example.demo.entities.AddRezervacijaResponse;
import com.example.demo.entities.AddSmestajRequest;
import com.example.demo.entities.AddSmestajResponse;
import com.example.demo.entities.GetAllSmestajRequest;
import com.example.demo.entities.GetAllSmestajResponse;
import com.example.demo.entities.GetPorukeRequest;
import com.example.demo.entities.GetPorukeResponse;
import com.example.demo.entities.GetRezervacijeRequest;
import com.example.demo.entities.GetRezervacijeResponse;
import com.example.demo.entities.GetUserCredentialRequest;
import com.example.demo.entities.GetUserCredentialResponse;
import com.example.demo.entities.Korisnik;
import com.example.demo.entities.Smestaj;
import com.example.demo.entities.Soba;
import com.example.demo.entities.UserCredential;
import com.example.demo.repository.SmestajRepository;
import com.example.demo.service.IPorukaService;

import com.example.demo.service.IRezervacijaService;

import com.example.demo.service.IKorisnikService;

import com.example.demo.service.ISmestajService;

@Endpoint
public class DemoEndpoint {

	
	@Autowired
    private ISmestajService smestajService;
	
	@Autowired
    private IKorisnikService korisnikService;
	
	@Autowired
    private IPorukaService porukaService;

	
	@Autowired
    private IRezervacijaService rezervacijaService;
	
	@PayloadRoot(namespace = "http://techprimers.com/demo",
            localPart = "addSmestajRequest")
    @ResponsePayload
    public AddSmestajResponse addSmestaj(@RequestPayload AddSmestajRequest request) {
		AddSmestajResponse response = new AddSmestajResponse();
		
		
        response.setSmestaj(smestajService.insertAccommodation((request.getSmestaj())));
        return response;
    }
	
	@PayloadRoot(namespace = "http://techprimers.com/demo",
            localPart = "addMessageRequest")
    @ResponsePayload
    public AddMessageResponse addMessage(@RequestPayload AddMessageRequest request) {
		AddMessageResponse response = new AddMessageResponse();
		
		System.out.println("POGODIO INSERTOVANJE PORUKE");
        response.setPoruka(porukaService.insertMessage(request.getPoruka()));
        
        if (response.getPoruka() != null) {
        	
        	Korisnik klijent = korisnikService.getUserById(request.getPoruka().getIdKlijenta()).get();
            klijent.getPrimljenePoruke().add(request.getPoruka());
    		korisnikService.save(klijent);
    		
    		Korisnik agent = korisnikService.getUserById(request.getPoruka().getIdAgenta()).get();
    		agent.getPoslatePoruke().add(request.getPoruka());
    		korisnikService.save(agent);
           
        	
        }
        
        return response;
        
    }
	
	@PayloadRoot(namespace = "http://techprimers.com/demo",
            localPart = "getPorukeRequest")
    @ResponsePayload
    public GetPorukeResponse getPoruke(@RequestPayload GetPorukeRequest request) {
		GetPorukeResponse response = new GetPorukeResponse();
		
		Korisnik agent = korisnikService.getUserById(request.getId()).get();
        response.setPoruke(agent.getPrimljenePoruke());
        return response;
    }
	
	@PayloadRoot(namespace = "http://techprimers.com/demo",
            localPart = "addRezervacijaRequest")
    @ResponsePayload
    public AddRezervacijaResponse addRezervacija(@RequestPayload AddRezervacijaRequest request) {
		AddRezervacijaResponse response = new AddRezervacijaResponse();
		
		
        response.setRezervacija(rezervacijaService.update(request.getRezervacija()));
        
        return response;
	}
	
    @PayloadRoot(namespace = "http://techprimers.com/demo",
            localPart = "getRezervacijeRequest")
    @ResponsePayload
    public GetRezervacijeResponse getRezervacije(@RequestPayload GetRezervacijeRequest request) {
    	GetRezervacijeResponse response = new GetRezervacijeResponse();
		
    	List<Smestaj> smestaji = smestajService.getSmestajbyUserId(request.getId());
    	
    	List<Rezervacija> rezervacije = new ArrayList<>();
    	for (Smestaj s : smestaji) {
    		
    		for (Soba soba : s.getSobe()) {
    			
    			for (Rezervacija rez : soba.getRezervacije()) {
    				
    				rezervacije.add(rez);
    			}
    		}
    	}
    	response.setRezervacije(rezervacije);
        return response;
    }
    
    @PayloadRoot(namespace = "http://techprimers.com/demo",
            localPart = "getUserCredentialRequest")
    @ResponsePayload
    public GetUserCredentialResponse getUserCredential(@RequestPayload GetUserCredentialRequest request) {
		GetUserCredentialResponse response = new GetUserCredentialResponse();
		
		Korisnik korisnik=korisnikService.getUserByEmail(request.getEmail()).get();
		UserCredential userCredential=new UserCredential();
		userCredential.setEmail(request.getEmail());
		userCredential.setId(korisnik.getId());
		userCredential.setPassword(korisnik.getPassword());
		
        response.setUserCredential(userCredential);
        return response;
    }
	
	
	@PayloadRoot(namespace = "http://techprimers.com/demo",
            localPart = "getAllSmestajRequest")
    @ResponsePayload
    public GetAllSmestajResponse getAllSmestaj(@RequestPayload GetAllSmestajRequest request) {
		GetAllSmestajResponse response = new GetAllSmestajResponse();
		
		List<Smestaj> smestajList=smestajService.getSmestajByAgentId(request.getAgentId());
		response.setSmestajList(smestajList);
        return response;
        
    }
	
	
}
