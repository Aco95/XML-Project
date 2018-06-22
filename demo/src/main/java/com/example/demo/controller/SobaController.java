package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Rezervacija;
import com.example.demo.entities.Smestaj;
import com.example.demo.entities.Soba;
import com.example.demo.service.ISmestajService;
import com.example.demo.service.ISobaService;

@RestController
@RequestMapping("/public/rooms")
@CrossOrigin(origins = "*")
public class SobaController {
	
	
	@Autowired
	private ISobaService sobaService;
	
	@Autowired
	private ISmestajService smestajService;
	
	
	@RequestMapping(value="/getSmestajID", method=RequestMethod.POST)
	public ResponseEntity<Object> getSmestajID(@RequestBody String roomID) {
		
		System.out.println("Trazim id smestaja");
		String smestajID = sobaService.getSmestajID(roomID);
		
		return new ResponseEntity<Object>(smestajID,HttpStatus.OK);
	}
	
	
	@RequestMapping(
			value = "/getAll",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Soba> getAll(){
		
		System.out.println("Pogodio getAll!");
		return sobaService.getAll();
	}
	
	
	@RequestMapping(
			value = "/getAccommodationFreeRooms/{accommodationID}/{numberOfPersons}/{dateFrom}/{dateTo}",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Soba> getAccommodationFreeRooms(@PathVariable("accommodationID") String accommodationID,
			@PathVariable("numberOfPersons") String numberOfPersons,
			@PathVariable("dateFrom") String dateFrom, @PathVariable("dateTo") String dateTo) throws DatatypeConfigurationException{
		
		
		Smestaj smestaj = smestajService.getSmestajById(accommodationID.substring(1, accommodationID.length()-1)).get();
		
		int brojOsoba = Integer.parseInt(numberOfPersons.substring(1, numberOfPersons.length()-1));
		
		String splitted[] = dateFrom.substring(1, dateFrom.length()-1).split(",");
		String godinaDolaska = splitted[0].split(":")[1];
		String mesecDolaska = splitted[1].split(":")[1];
		if(mesecDolaska.length()==1)
			mesecDolaska = "0" + mesecDolaska;
		String danDolaska = splitted[2].split(":")[1];
		if(danDolaska.length()==1)
			danDolaska = "0" + danDolaska;
		String datumDolaskaStr = godinaDolaska+"-"+mesecDolaska+"-"+danDolaska;
		
		String splitted2[] = dateTo.substring(1, dateTo.length()-1).split(",");
		String godinaOdlaska = splitted2[0].split(":")[1];
		String mesecOdlaska = splitted2[1].split(":")[1];
		if(mesecOdlaska.length()==1)
			mesecOdlaska = "0" + mesecOdlaska;
		String danOdlaska = splitted2[2].split(":")[1];
		if(danOdlaska.length()==1)
			danOdlaska = "0" + danOdlaska;
		String datumOdlaskaStr = godinaOdlaska+"-"+mesecOdlaska+"-"+danOdlaska;
		
	
		XMLGregorianCalendar datumDolaska = DatatypeFactory.newInstance().newXMLGregorianCalendar(datumDolaskaStr);
		XMLGregorianCalendar datumOdlaska = DatatypeFactory.newInstance().newXMLGregorianCalendar(datumOdlaskaStr);
            
		
		List<Soba> slobodneSobe = new ArrayList<Soba>();
		
		for(Soba soba : smestaj.getSoba()) {
			if(soba.getKapacitet()==brojOsoba) {
				
				if(soba.getRezervacija().isEmpty()) {		// soba nikada nije rezervisana do sad
					if(!slobodneSobe.contains(soba)) {
						slobodneSobe.add(soba);
						continue;
					}
				}
				
				boolean slobodna = true;
				for(Rezervacija rez : soba.getRezervacija()) {
					
					if(isBetween(datumDolaska, rez.getOd(), rez.getDo()) || isBetween(datumOdlaska, rez.getOd(), rez.getDo())) {
						System.out.println("soba "+soba.getBroj()+" je zauzeta tada..");
						slobodna = false;
						break;
					}	
		
				}
				
				if(slobodna) {
					if(!slobodneSobe.contains(soba)) {
						slobodneSobe.add(soba);
					}
				}
				
			}
		}
		
		return slobodneSobe;
	}

	
	
	
	public boolean isBetween(XMLGregorianCalendar date,
	        XMLGregorianCalendar start, XMLGregorianCalendar end) {
	    return (date.compare(start) == DatatypeConstants.GREATER || date
	            .compare(start) == DatatypeConstants.EQUAL)
	            && (date.compare(end) == DatatypeConstants.LESSER || date
	                    .compare(end) == DatatypeConstants.EQUAL);
	}
	
}
