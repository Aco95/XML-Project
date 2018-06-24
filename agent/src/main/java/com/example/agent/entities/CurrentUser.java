package com.example.agent.entities;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 5119798847634486546L;
	private UserCredential korisnik;
	//private Korisnik korisnik;

    public CurrentUser(UserCredential korisnik) {
        super(korisnik.getEmail(), korisnik.getPassword(), AuthorityUtils.createAuthorityList(Uloga.AGENT.toString()));
        this.korisnik = korisnik;
    }

    public UserCredential getUser() {
        return korisnik;
    }

    public String getId() {
        return korisnik.getId();
    }

    public Uloga getRole() {
        return Uloga.AGENT;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + korisnik +
                "} " + super.toString();
    }
}
