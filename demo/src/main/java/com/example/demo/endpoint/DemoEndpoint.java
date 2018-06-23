package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import com.example.demo.entities.AddSmestajRequest;
import com.example.demo.entities.AddSmestajResponse;
import com.example.demo.service.ISmestajService;

@Endpoint
public class DemoEndpoint {

	
	@Autowired
    private ISmestajService smestajService;
	
	@PayloadRoot(namespace = "http://techprimers.com/demo",
            localPart = "addSmestajRequest")
    @ResponsePayload
    public AddSmestajResponse addSmestaj(@RequestPayload AddSmestajRequest request) {
		AddSmestajResponse response = new AddSmestajResponse();
		
		
        response.setSmestaj(smestajService.insertAccommodation((request.getSmestaj())));
        return response;
    }
	
}
