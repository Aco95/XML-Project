package com.example.demo.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Recenzija;
import com.example.demo.service.IRecenzijaService;

@Service
public class RecenzijaServiceImpl implements IRecenzijaService {
	
	final private String baseUri="http://localhost:8010/rejting-remote/us-central1/";
	@Override
	public void setRecenzija(Recenzija recenzija) {
		String url=baseUri+"set";
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<String> result = restTemplate.postForEntity(url, recenzija, String.class);
	    System.out.println("***********************http request post sent***************");
	    System.out.println(result.getBody());	   
	    System.out.println("***********************http request post received***************");

	}

	@Override
	public Recenzija getRecenzijaById(String recenzijaId) {
		String url=baseUri+"get?id="+recenzijaId;
	    RestTemplate restTemplate = new RestTemplate();
	    Recenzija result = restTemplate.getForObject(url, Recenzija.class);
	    System.out.println("***********************http request get sent***************");
	    System.out.println(result);	 
	    System.out.println("***********************http request get received***************");
	    return result;
	}

	@Override
	public List<String> findByRejting(int prosecanRejting) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculateAverageRejtingForSmestaj(String smestajId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
