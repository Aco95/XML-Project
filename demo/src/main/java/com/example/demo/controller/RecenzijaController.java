package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Komentar;
import com.example.demo.entities.Recenzija;
import com.example.demo.service.IRecenzijaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/recenzijaOffline"})
public class RecenzijaController {
	
	@Autowired
	private IRecenzijaService recenzijaService;
	
	@GetMapping
	public List<Recenzija> getComments(){														
		System.out.println("DEBUG::PRONALAZI RECENZIJE");
		return recenzijaService.findAll();	
	}
	
}
