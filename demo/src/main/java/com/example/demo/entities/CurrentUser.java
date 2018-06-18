package com.example.demo.entities;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 5119798847634486546L;
	private Korisnik korisnik;

    public CurrentUser(Korisnik korisnik) {
        super(korisnik.getEmail(), korisnik.getPassword(), AuthorityUtils.createAuthorityList(korisnik.getUloga().toString()));
        this.korisnik = korisnik;
    }

    public Korisnik getUser() {
        return korisnik;
    }

    public String getId() {
        return korisnik.getId();
    }

    public Uloga getRole() {
        return korisnik.getUloga();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + korisnik +
                "} " + super.toString();
    }
}
