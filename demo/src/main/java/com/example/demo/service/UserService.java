package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import com.example.demo.entities.Korisnik;
import com.example.demo.entities.UserCreateForm;

public interface UserService {

	Optional<Korisnik> getUserById(String id);

	Optional<Korisnik> getUserByEmail(String email);

	Collection<Korisnik> getAllUsers();

	Korisnik create(UserCreateForm form);

}
