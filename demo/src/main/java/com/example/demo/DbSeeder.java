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
import com.example.demo.entities.Tip;
import com.example.demo.entities.Uloga;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.SmestajRepository;
import com.example.demo.repository.SobaRepository;


@Component
public class DbSeeder implements CommandLineRunner{
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private SobaRepository sobaRepository;
	
	@Autowired
	private SmestajRepository smestajRepository;
	
	

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
		k1.setUloga(Uloga.ADMIN);
		
		Korisnik k2 = new Korisnik();
		k2.setId("2");
		k2.setAdresa("Milovan Jelica 32");
		k2.setIme("Pera");
		k2.setPrezime("Peric");
		k2.setUsername("pp");
		k2.setMaticniBroj("1234567890123");
		k2.setPassword("test1234");
		k2.setUloga(Uloga.AGENT);
		
		Korisnik k3 = new Korisnik();
		k3.setId("3");
		k3.setAdresa("Milovan Jelica 32");
		k3.setIme("Nikola");
		k3.setPrezime("Nikolic");
		k3.setUsername("nn");
		k3.setMaticniBroj("1234567890123");
		k3.setPassword("test1234");
		k3.setUloga(Uloga.USER);
		
		
		korisnikRepository.deleteAll();
		
		List<Korisnik> korisnici = Arrays.asList(k1,k2,k3);
		
		korisnikRepository.saveAll(korisnici);
		
		
		Soba s1 = new Soba();
		s1.setId("1");
		s1.setBroj(1);
		s1.setKapacitet(1); 	// jednokrevetna
		s1.setDatumiRezervacija(new ArrayList<String>());
		s1.setIdSmestaja("1");
		
		Soba s2 = new Soba();
		s2.setId("2");
		s2.setBroj(2);
		s2.setKapacitet(2); 	// dvokrevetna
		s2.setDatumiRezervacija(new ArrayList<String>());
		s2.setIdSmestaja("1");
		
		Soba s5 = new Soba();
		s5.setId("5");
		s5.setBroj(5);
		s5.setKapacitet(2); 	// dvokrevetna
		ArrayList<String> datumi_rez = new ArrayList<String>();
		datumi_rez.add("17-06-2018 23-06-2018");
		datumi_rez.add("01-07-2018 12-07-2018");
		s5.setDatumiRezervacija(datumi_rez);
		s5.setIdSmestaja("1");
		
		
		
		Soba s3 = new Soba();
		s3.setId("3");
		s3.setBroj(3);
		s3.setKapacitet(3); 	// trokrevetna
		s3.setDatumiRezervacija(new ArrayList<String>());
		s3.setIdSmestaja("2");
		
		Soba s4 = new Soba();
		s4.setId("4");
		s4.setBroj(4);
		s4.setKapacitet(4); 	// cetvorokrevetna
		s4.setDatumiRezervacija(new ArrayList<String>());
		s4.setIdSmestaja("2");
		
		sobaRepository.deleteAll();
		
		List<Soba> sobe = Arrays.asList(s1,s2,s3,s4,s5);
		
		sobaRepository.saveAll(sobe);
		
		List<Soba> sobe1 = Arrays.asList(s1,s2,s5);
		Smestaj smestaj1 = new Smestaj();
		smestaj1.setId("1");
		smestaj1.setNaziv("Hotel Park");
		smestaj1.setMesto("Novi Sad");
		smestaj1.setAdresa("Bulevar Kralja Aleksandra 24");
		smestaj1.setKategorija(4);
		smestaj1.setTip(Tip.HOTEL);
		smestaj1.setOcena(8.7);
		smestaj1.setOpis("Najbolji hotel u gradu...");
		smestaj1.setSobe(sobe1);
		smestaj1.setSlikeUrl(new ArrayList<String>());
		smestaj1.setParking(true);
		smestaj1.setWifi(true);
		smestaj1.setPansion(true);
		smestaj1.setDorucak(true);
		smestaj1.setPolupansion(true);
		smestaj1.setMiniKuhinja(true);
		smestaj1.setPrivatnoKupatilo(true);
		smestaj1.setTv(true);
		
		
		List<Soba> sobe2 = Arrays.asList(s3,s4);
		Smestaj smestaj2 = new Smestaj();
		smestaj2.setId("2");
		smestaj2.setNaziv("Apartmani Jancic");
		smestaj2.setMesto("Smederevo");
		smestaj2.setAdresa("Lukijana Musickog 17");
		smestaj2.setKategorija(3);
		smestaj2.setTip(Tip.APARTMAN);
		smestaj2.setOcena(9.1);
		smestaj2.setOpis("Najbolji apartmani u Smederevu i sire...");
		smestaj2.setSobe(sobe2);
		smestaj2.setSlikeUrl(new ArrayList<String>());
		smestaj2.setParking(false);
		smestaj2.setWifi(true);
		smestaj2.setPansion(false);
		smestaj2.setDorucak(true);
		smestaj2.setPolupansion(true);
		smestaj2.setMiniKuhinja(true);
		smestaj2.setPrivatnoKupatilo(true);
		smestaj2.setTv(true);
		
		 
		smestajRepository.deleteAll();
		
		List<Smestaj> smestaji = Arrays.asList(smestaj1,smestaj2);
		
		smestajRepository.saveAll(smestaji);
		
	}

}
