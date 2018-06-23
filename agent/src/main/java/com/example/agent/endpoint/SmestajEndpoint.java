package com.example.agent.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.agent.entities.GetSmestajRequest;
import com.example.agent.entities.GetSmestajResponse;
import com.example.agent.services.SmestajService;



@Endpoint
public class SmestajEndpoint {

	@Autowired
    private SmestajService smestajService;
	
	@PayloadRoot(namespace = "http://www.w3.org/2001/XMLSchema/agent",
            localPart = "getSmestajRequest")
    @ResponsePayload
    public GetSmestajResponse getSmestaj(@RequestPayload GetSmestajRequest request) {
		GetSmestajResponse response = new GetSmestajResponse();
		
		System.out.println("DA VIDIMO: " + request.getId());
        response.setSmestaj(smestajService.getById(request.getId()).get());
        return response;
    }
}
