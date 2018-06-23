package com.example.agent.services.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agent.entities.Korisnik;
import com.example.agent.entities.UserCredential;
import com.example.agent.repositories.UserCredentialRepository;
import com.example.agent.services.IUserCredentialService;

@Service
public class UserCredentialServiceImpl implements IUserCredentialService{

	@Autowired
	private UserCredentialRepository userCredentialRepository; 
	
	@Override
	public Optional<UserCredential> getUserByEmail(String email) {
		Optional<UserCredential> korisnik =userCredentialRepository.findOneByEmail(email);
		System.out.println("korisnik servis***");
		return korisnik;
	}
}
