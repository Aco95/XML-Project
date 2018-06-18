package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Komentar;
import com.example.demo.service.CommentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/api_comment"})
public class KomentarController {
	
	@Autowired
	private CommentService commentService;
	
	
	@GetMapping
	public List<Komentar> getComments(){													
		List<Komentar> komentari = commentService.getAllComments();
		if(komentari.isEmpty()){
			Komentar c = new Komentar(null,"Insert message here", false);
			commentService.addComment(c);
			
			Komentar c2 = new Komentar(null,"Insert message here2", false);
			commentService.addComment(c2);
			
			Komentar c3 = new Komentar(null,"Insert message here3", false);
			commentService.addComment(c3);
			
			Komentar c4 = new Komentar(null,"Insert message here4", false);
			commentService.addComment(c4);
			
			Komentar c5 = new Komentar(null,"Insert message here5", false);
			commentService.addComment(c5);
			
			Komentar c6 = new Komentar(null,"Insert message here6", false);
			commentService.addComment(c6);
		}
		
		System.out.println("DEBUG::PRONALAZI PORUKE");
		return commentService.findNotAllowed(false);
		//return komentari;
	}
	
	@PutMapping
	public void allowComemnt(@RequestBody Komentar k){
		//commentService.findCommentById(k.getId()).get().setOdobren(true);
		System.out.println("ULAZI U MENJANJE KOMENTARA");
		k.setOdobren(true);
		commentService.addComment(k);
	}
}
