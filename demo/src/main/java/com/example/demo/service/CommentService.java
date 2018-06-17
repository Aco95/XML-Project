package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Komentar;

public interface CommentService {
	public List<Komentar> getAllComments();
	public Komentar addComment(Komentar k);
	public Optional<Komentar> findCommentById(String id);
	public List<Komentar> findNotAllowed(Boolean allowed);
}
