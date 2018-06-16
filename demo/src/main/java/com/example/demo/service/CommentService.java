package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Komentar;

public interface CommentService {
	public List<Komentar> getAllComments();
	public Komentar addComment(Komentar k);
	
}
