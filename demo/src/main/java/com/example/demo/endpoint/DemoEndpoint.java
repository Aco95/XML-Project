package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import com.example.demo.entities.AddSmestajRequest;
import com.example.demo.entities.AddSmestajResponse;
import com.example.demo.entities.GetUserCredentialRequest;
import com.example.demo.entities.GetUserCredentialResponse;
import com.example.demo.entities.Korisnik;
import com.example.demo.entities.UserCredential;
import com.example.demo.service.IKorisnikService;
import com.example.demo.service.ISmestajService;

@Endpoint
public class DemoEndpoint {

	
	@Autowired
    private ISmestajService smestajService;
	
	@Autowired
    private IKorisnikService korisnikService;
	
	@PayloadRoot(namespace = "http://techprimers.com/demo",
            localPart = "addSmestajRequest")
    @ResponsePayload
    public AddSmestajResponse addSmestaj(@RequestPayload AddSmestajRequest request) {
		AddSmestajResponse response = new AddSmestajResponse();
		
		
        response.setSmestaj(smestajService.insertAccommodation((request.getSmestaj())));
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
	
}
