package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Korisnik;
import com.example.demo.entities.UserCreateForm;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<Korisnik> getUserById(String id) {
		LOGGER.debug("Getting user={}", id);
		return userRepository.findById(id);
	}

	@Override
	public Optional<Korisnik> getUserByEmail(String email) {
		LOGGER.debug("Getting user by email={}", email);
		return userRepository.findOneByEmail(email);
	}

	@Override
	public Collection<Korisnik> getAllUsers() {
		LOGGER.debug("Getting all users");
		return userRepository.findAll();
	}

	@Override
	public Korisnik create(UserCreateForm form) {
		Korisnik korisnik = new Korisnik();
		korisnik.setEmail(form.getEmail());
		korisnik.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
		korisnik.setUloga(form.getRole());
		return userRepository.save(korisnik);
	}

}
