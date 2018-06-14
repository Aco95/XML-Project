package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Korisnik;
import com.example.demo.entities.Smestaj;
import com.example.demo.entities.Soba;
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
		
		
		this.korisnikRepository.deleteAll();
		
		List<Korisnik> korisnici = Arrays.asList(k1,k2);
		
		korisnikRepository.saveAll(korisnici);
		
		
		Soba s1 = new Soba();
		s1.setId("1");
		s1.setBroj(1);
		s1.setKapacitet(1); 	// jednokrevetna
		
		Soba s2 = new Soba();
		s2.setId("2");
		s2.setBroj(2);
		s2.setKapacitet(2); 	// dvokrevetna
		
		Soba s3 = new Soba();
		s3.setId("3");
		s3.setBroj(3);
		s3.setKapacitet(3); 	// trokrevetna
		
		Soba s4 = new Soba();
		s4.setId("4");
		s4.setBroj(4);
		s4.setKapacitet(4); 	// cetvorokrevetna
		
		
		
		
		 
		
	}

}
