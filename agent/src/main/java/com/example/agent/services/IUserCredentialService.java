package com.example.agent.services;

import java.util.Optional;

import javax.xml.bind.annotation.XmlElement;

import org.springframework.data.annotation.Id;

import com.example.agent.entities.Korisnik;
import com.example.agent.entities.UserCredential;

public interface IUserCredentialService {
	Optional<UserCredential> getUserByEmail(String email);
	boolean checkEmail(String email);
}
