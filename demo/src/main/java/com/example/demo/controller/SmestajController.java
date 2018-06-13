package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Smestaj;
import com.example.demo.repository.SmestajRepository;

@RestController
@RequestMapping("/public/accommodations")
@CrossOrigin(origins = "*")
public class SmestajController {
	
	@Autowired
	private SmestajRepository smestajRepository;
	
	
	@RequestMapping(
			value = "/getAll",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Smestaj> getAll(){
			
		return smestajRepository.findAll();
	}
	
	
//	@RequestMapping(
//			value = "/getAccommodationByPlace/{place}",
//			method = RequestMethod.GET, 
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<Smestaj> getAccommodationByPlace(@PathVariable("place") String place){
//		
//		return smestajRepository.findByPlace(place);
//		
//	}
	
	
	@RequestMapping(
			value = "/basicSearch/{place}/{numberOfPersons}/{dateFrom}/{dateTo}",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Smestaj> basicSearch(@PathVariable("place") String place,
			@PathVariable("numberOfPersons") int numberOfPersons,
			@PathVariable("dateFrom") String dateFrom, @PathVariable("dateTo") String dateTo){
		
		
		return smestajRepository.findByPlace(place);
		
	}

}
