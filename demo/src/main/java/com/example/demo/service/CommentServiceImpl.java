package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Komentar;
import com.example.demo.repository.KomentarRepository;

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
		// TODO Auto-generated method stub
		return null;
	}

}
