package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.agentskiModel.GetSmestajRequest;
import com.example.demo.agentskiModel.GetSmestajResponse;
import com.example.demo.agentskiModel.Smestaj;
import com.example.demo.agentskiModel.SmestajServicePort;
import com.example.demo.agentskiModel.SmestajServicePortService;


@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello Mavene Jodza");
//
//		SmestajServicePortService smestajServicePortService = new SmestajServicePortService();
//		SmestajServicePort port = smestajServicePortService.getSmestajServicePortSoap11();
//		GetSmestajRequest getSmestajRequest = new GetSmestajRequest();
//		getSmestajRequest.setId("1");
//		
//		
//		System.out.println(getSmestajRequest.getId());
//		GetSmestajResponse getSmestajResponse = port.getSmestaj(getSmestajRequest);
//		
//		Smestaj smestaj = getSmestajResponse.getSmestaj();
//		
//		System.out.println("preuzeo sam smestaj: " + smestaj.getNaziv());
		
		
	}
}
