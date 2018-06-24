package com.example.demo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Recenzija;
import com.example.demo.repository.RecenzijaRepository;
import com.example.demo.service.IRecenzijaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Service
public class RecenzijaServiceImpl implements IRecenzijaService {
	
	@Autowired
	RecenzijaRepository recenzijaRepository;
	
	final private String baseUri="http://localhost:8010/test-id/us-central1/";
	@Override
	public void setRecenzija(Recenzija recenzija) {
		String url=baseUri+"set";
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json="{\"queriedQuestion\":\"Is there pain in your hand?\"}";
		try {
			json = ow.writeValueAsString(recenzija);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(json,headers);
		String answer = restTemplate.postForObject(url, entity, String.class);
		System.out.println(answer);
		
//		HttpEntity<Recenzija> request = new HttpEntity<>(recenzija);
//		ResponseEntity<Recenzija> response = restTemplate
//		  .exchange(url, HttpMethod.POST, request, Recenzija.class);
////
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		//set your entity to send
//		HttpEntity entity = new HttpEntity(recenzija,headers);
//
//		// send it!
//		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity
//		    , String.class);
///
//		assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
		
//	    RestTemplate restTemplate = new RestTemplate();
//	    
//	    String result=restTemplate.postForObject(url, recenzija, String.class);
//	    //ResponseEntity<String> result = restTemplate.postForEntity(url, new Reque, String.class);


	}

	@Override
	public Recenzija getRecenzijaById(String recenzijaId) {
		String url=baseUri+"get?id="+recenzijaId;
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class);
	    System.out.println("***********************http request get sent***************");
	    ObjectMapper objectMapper = new ObjectMapper();
	    Recenzija rec=new Recenzija();
	    try {
			rec = objectMapper.readValue(result, Recenzija.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(result);	 
	    System.out.println("rec id: "+rec.getKomentar().getSadrzaj());	 
	    System.out.println("***********************http request get received***************");
	    return rec;
	}

	@Override
	public List<Recenzija> findBySmestajAndRejting(String smestajId,int ocena) {
		String url=baseUri+"findBySmestajAndRejting?smestajId="+smestajId+"&"+"ocena="+ocena;
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class);
	    System.out.println("***********************http request get sent***************");
	    ObjectMapper objectMapper = new ObjectMapper();
	    List<Recenzija> recList=new ArrayList<Recenzija>();
	    try {
	    	recList = objectMapper.readValue(result, new TypeReference<List<Recenzija>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(result);	 
	    System.out.println("rec lista velicina: "+recList.size());	 
	    System.out.println("***********************http request get received***************");
	    return recList;
	}

	@Override
	public int calculateAverageRejtingForSmestaj(String smestajId) {
		String url=baseUri+"calculateAverageRejtingForSmestaj?filter=smestajId&value="+smestajId;
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class);
	    System.out.println("***********************http request get sent***************");
	    ObjectMapper objectMapper = new ObjectMapper();
	    int rejting=0;
	    try {
	    	rejting = objectMapper.readValue(result, int.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(result);	 
	    System.out.println("rejting je: "+rejting);	 
	    System.out.println("***********************http request get received***************");
	    return rejting;
	}

	@Override
	public List<Recenzija> findByNotAllowed(Boolean allowed) {
		String url=baseUri+"findByNotAllowed?allowed="+allowed;
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class);
	    System.out.println("***********************http request get sent***************");
	    ObjectMapper objectMapper = new ObjectMapper();
	    List<Recenzija> recList=new ArrayList<Recenzija>();
	    try {
	    	recList = objectMapper.readValue(result, new TypeReference<List<Recenzija>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(result);	 
	    System.out.println("rec lista allowed:"+allowed+" velicina: "+recList.size());	 
	    System.out.println("***********************http request get received***************");
	    return recList;
	}

	@Override
	public List<Recenzija> findAll() {
		return recenzijaRepository.findAll();
	}

}
