package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Komentar;
import com.example.demo.repository.KomentarRepository;
import com.example.demo.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	KomentarRepository komentarRepository;
	
	@Override
	public List<Komentar> getAllComments() {
		return komentarRepository.findAll();
	}

	@Override
	public Komentar addComment(Komentar k) {
		return komentarRepository.save(k);
	}

	@Override
	public Optional<Komentar> findCommentById(String id) {
		return komentarRepository.findById(id);
	}

	@Override
	public List<Komentar> findNotAllowed(Boolean allowed) {
		
		return komentarRepository.findByOdobren(allowed);
	}

	

}
