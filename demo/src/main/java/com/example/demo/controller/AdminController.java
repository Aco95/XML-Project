package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdminKorisnikDto;
import com.example.demo.service.AdminServiceImp;

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
			value = "/korisnik/block/{id}",
			method = RequestMethod.PUT) 
	public void  blokirajKorisnika(@PathVariable("id") int id){
			adminService.blokKorisnik(id);
	}
	
	@RequestMapping(
			value = "/korisnik/activate/{id}",
			method = RequestMethod.PUT)
	public void  aktivirajKorisnika(@PathVariable("id") int id){
			adminService.aktivirajKorisnik(id);
	}
	
	@RequestMapping(
			value = "/korisnik/{id}",
			method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void  obrisiKorisnika(@PathVariable("id") int id){
			adminService.obrisiKorisnik(id);
	}
	
}
