package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Korisnik;
import com.example.demo.repository.KorisnikRepository;


@Component
public class DbSeeder implements CommandLineRunner{
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Korisnik k1 = new Korisnik();
		k1.setId("1");
		k1.setAdresa("Milovan Jelica 32");
		k1.setIme("Marko");
		k1.setPrezime("Markovic");
		k1.setUsername("mm");
		k1.setMaticniBroj("1234567890123");
		k1.setPassword("test1234");
		k1.setUloga(1);
		
		Korisnik k2 = new Korisnik();
		k2.setId("2");
		k2.setAdresa("Milovan Jelica 32");
		k2.setIme("Pera");
		k2.setPrezime("Peric");
		k2.setUsername("pp");
		k2.setMaticniBroj("1234567890123");
		k2.setPassword("test1234");
		k2.setUloga(2);
		
		
		System.out.println("Izvrsio se");
		
		this.korisnikRepository.deleteAll();
		
		List<Korisnik> korisnici = Arrays.asList(k1,k2);

		korisnikRepository.deleteAll();
		
		korisnikRepository.saveAll(korisnici);
		
		 
		
	}

}
