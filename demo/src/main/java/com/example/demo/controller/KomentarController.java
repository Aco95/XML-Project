package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Komentar;
import com.example.demo.service.CommentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/api_comment"})
public class KomentarController {
	
	private CommentService commentService;
	
	
	@GetMapping
	public List<Komentar> getComments(){
		
		List<Komentar> komentari = new ArrayList<Komentar>();
		
		for(int i=0; i<10; i++){
			Komentar c = new Komentar(null,"Insert message here", false);
			komentari.add(c);
		}
		
		System.out.println("DEBUG::PRONALAZI PORUKE");
		//return commentService.getAllComments();
		return komentari;
	}
}
