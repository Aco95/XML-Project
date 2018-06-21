package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdminKorisnikDto;
import com.example.demo.dto.AgentRegisterDto;
import com.example.demo.service.impl.AdminServiceImp;



@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	private AdminServiceImp adminService;
	
	@RequestMapping(value = "/korisnik",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AdminKorisnikDto>  getAllKorisnik(){
		return adminService.getAllKorisnik();
	}
	
	@RequestMapping(
			value = "/korisnik/{id}/{blokiran}",
			method = RequestMethod.GET) 
	public void  promeniStatusKorisnika(@PathVariable("id") String id,@PathVariable("blokiran") boolean blokiran){
			adminService.promeniStatusKorisnik(id, blokiran);
	}
	@RequestMapping(
			value = "/korisnik/{id}",
			method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void  obrisiKorisnika(@PathVariable("id") String id){
			adminService.obrisiKorisnik(id);
	}
	
	@RequestMapping(
			value = "/agent",
			method = RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public void  registrujAgenta(@RequestBody  AgentRegisterDto agentRegisterDto){
			adminService.registrujAgenta(agentRegisterDto);
	}
	
}
