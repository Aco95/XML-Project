package com.example.agent.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.agent.services.SmestajService;
import com.example.agent.demoModel.AddSmestajRequest;
import com.example.agent.demoModel.AddSmestajResponse;
import com.example.agent.demoModel.DemoServicePort;
import com.example.agent.demoModel.DemoServicePortService;
import com.example.agent.dtos.SmestajDTO;
import com.example.agent.entities.Rezervacija;
import com.example.agent.entities.Smestaj;
import com.example.agent.entities.Soba;
import com.example.agent.entities.Tip;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.http.MediaType;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/smestaji")
public class SmestajController {

	@Autowired
	private SmestajService smestajService;
	
	
	@RequestMapping(
			value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)

	public List<Smestaj> getSmestaji() {
		
		return smestajService.getSmestaji();
		
	}
	
	@RequestMapping(
			value = "/insert",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Smestaj registerSmestaj(@RequestBody SmestajDTO sDTO) {
			
		int brojSoba = sDTO.getBrJednokrevetnih() + sDTO.getBrDvokrevetnih() + sDTO.getBrTrokrevetnih() + sDTO.getBrCetvorokrevetnih();
		Smestaj smestaj = new Smestaj();
		List<Soba> sobe = new ArrayList<Soba>();
		Random rn = new Random();
		
		for (int i = 0; i < brojSoba; i++) {
			
			Soba soba = new Soba();
			soba.setId(rn.nextInt(999999) + 100000 + "");
			soba.setIdSmestaja(sDTO.getId());
			soba.setRezervacije(new ArrayList<Rezervacija>());
			soba.setBroj(i + 1);
			
			if (i < sDTO.getBrJednokrevetnih()) {
				
				soba.setKapacitet(1);
				
			} else if (i >= sDTO.getBrJednokrevetnih() && i < sDTO.getBrJednokrevetnih() + sDTO.getBrDvokrevetnih()) {
				
				soba.setKapacitet(2);
				
			} else if (i >= sDTO.getBrJednokrevetnih() + sDTO.getBrDvokrevetnih() && i < sDTO.getBrJednokrevetnih() + sDTO.getBrDvokrevetnih() + sDTO.getBrTrokrevetnih()) {
				
				soba.setKapacitet(3);
				
			} else if (i >= sDTO.getBrJednokrevetnih() + sDTO.getBrDvokrevetnih() + sDTO.getBrTrokrevetnih()) {
				
				soba.setKapacitet(4);
			}
			
			sobe.add(soba);
			
		}
		
		smestaj.setId(Calendar.getInstance().getTimeInMillis() + "");
		smestaj.setNaziv(sDTO.getNaziv());
		smestaj.setAdresa(sDTO.getAdresa());
		smestaj.setMesto(sDTO.getMesto());
		smestaj.setKategorija(sDTO.getKategorija());
		smestaj.setTip(sDTO.getTip());
		smestaj.setWifi(sDTO.getWifi());
		smestaj.setParking(sDTO.getParking());
		smestaj.setDorucak(sDTO.getDorucak());
		smestaj.setPansion(sDTO.getPansion());
		smestaj.setPolupansion(sDTO.getPolupansion());
		smestaj.setMiniKuhinja(sDTO.getMiniKuhinja());
		smestaj.setPrivatnoKupatilo(sDTO.getPrivatnoKupatilo());
		smestaj.setOcena(sDTO.getOcena());
		smestaj.setOpis(sDTO.getOpis());
		smestaj.setSobe(sobe);
		smestaj.setSlikeUrl(sDTO.getSlikeUrl());
		
		com.example.agent.demoModel.Soba demoSoba = new com.example.agent.demoModel.Soba();
		List<com.example.agent.demoModel.Soba> demoSobe = new ArrayList<>();
		
		for (Soba soba : smestaj.getSobe()) {
			
			demoSoba.setBroj(soba.getBroj());
			demoSoba.setCena(soba.getCena());
			demoSoba.setId(soba.getId());
			demoSoba.setIdSmestaja(soba.getIdSmestaja());
			demoSoba.setKapacitet(soba.getKapacitet());
			
			demoSobe.add(demoSoba);
			
		}
		
		com.example.agent.demoModel.Smestaj demoSmestaj = new com.example.agent.demoModel.Smestaj();
		demoSmestaj.setId(smestaj.getId());
		demoSmestaj.setNaziv(smestaj.getNaziv());
		demoSmestaj.setAdresa(smestaj.getAdresa());
		demoSmestaj.setMesto(smestaj.getMesto());
		demoSmestaj.setKategorija(smestaj.getKategorija());
		demoSmestaj.setTip(com.example.agent.demoModel.Tip.valueOf(smestaj.getTip().value()));
		demoSmestaj.setWifi(smestaj.isWifi());
		demoSmestaj.setParking(smestaj.isParking());
		demoSmestaj.setDorucak(smestaj.isDorucak());
		demoSmestaj.setPansion(smestaj.isPansion());
		demoSmestaj.setPolupansion(smestaj.isPolupansion());
		demoSmestaj.setMiniKuhinja(smestaj.isMiniKuhinja());
		demoSmestaj.setPrivatnoKupatilo(smestaj.isPrivatnoKupatilo());
		demoSmestaj.setOcena(smestaj.getOcena());
		demoSmestaj.setOpis(smestaj.getOpis());
		demoSmestaj.setSobe(demoSobe);
		demoSmestaj.setSlikeUrl(smestaj.getSlikeUrl());
		
		//provera konekcije jer aplikacija treba da radi i u offline rezimu
		Socket sock = new Socket();
		InetSocketAddress addr = new InetSocketAddress("www.google.com", 80);
		
		try {
			
			sock.connect(addr);
			
			
			
			
			
		} catch (Exception e) {
		
			System.out.println("NEMA NETA");
			
			Smestaj nemaNeta = new Smestaj();
			nemaNeta.setNaziv("noInternetConnection");
			return nemaNeta;
			
		} finally {
			
			try {
				
				sock.close();
				
			} catch (Exception e) {
				
				System.out.println("Greska pri zatvaranju konekcije");
			}
			
		}
		
		System.out.println("IMA NETA");
		
		smestaj = smestajService.insertAccommodation(smestaj);
		
		if (smestaj != null) {
			
			
			DemoServicePortService demoServicePortService = new DemoServicePortService();
			DemoServicePort port = demoServicePortService.getDemoServicePortSoap11();
			AddSmestajRequest addSmestajRequest = new AddSmestajRequest();
			addSmestajRequest.setSmestaj(demoSmestaj);
			AddSmestajResponse addSmestajResponse = port.addSmestaj(addSmestajRequest);
			
			System.out.println("U glavnu bazu upisan smestaj: " + addSmestajResponse.getSmestaj().getNaziv());
		
			return smestaj;
			
		} else {
			
			return null;
		}
			
			
	}
	
}
