package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Komentar;
import com.example.demo.entities.Smestaj;
import com.example.demo.service.CommentService;
import com.example.demo.service.ISmestajService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/api_comment"})
public class KomentarController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ISmestajService smestajService;
	
	
	@GetMapping
	public List<Komentar> getComments(){														
		System.out.println("DEBUG::PRONALAZI PORUKE");
		return commentService.findNotAllowed(false);		
	}
	
	@PutMapping
	public void allowComemnt(@RequestBody Komentar k){
		//commentService.findCommentById(k.getId()).get().setOdobren(true);
		System.out.println("ULAZI U MENJANJE KOMENTARA");
		k.setOdobren(true);
		commentService.addComment(k);
	}
	
	@RequestMapping(
			value = "/getAll",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Smestaj> getAll(){
		
		System.out.println("Pogodio getAll!");
		return smestajService.getAll();
	}
	
	@RequestMapping(
			value = "/getActiveEdit/{id}",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Smestaj> getActiveEdit(@PathVariable("id") String id ){
		
		System.out.println("Pogodio getEdited");
		return smestajService.getSmestajById(id);
	}
}
