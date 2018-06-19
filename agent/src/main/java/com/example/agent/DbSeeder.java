package com.example.agent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.agent.entities.Korisnik;
import com.example.agent.entities.Poruka;
import com.example.agent.repositories.KorisnikRepository;
import com.example.agent.repositories.PorukaRepository;
import com.example.agent.repositories.SmestajRepository;
import com.example.agent.repositories.SobaRepository;
import com.example.agent.entities.Smestaj;
import com.example.agent.entities.Soba;
import com.example.agent.entities.Tip;
import com.example.agent.entities.Uloga;


@Component
public class DbSeeder implements CommandLineRunner{
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	
	@Autowired
	private SobaRepository sobaRepository;
	
	@Autowired
	private SmestajRepository smestajRepository;
	
	@Autowired
	private PorukaRepository porukaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
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
		
		List<Soba> sobe = Arrays.asList(s1,s2,s3,s4);
		
		sobaRepository.saveAll(sobe);
		
		List<String> slikeSmestaj1 = new ArrayList<String>();
		String sl1 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "hotelPark2.jpg";
		String sl2 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "hotelParkEnterijer.jpg";
		String sl3 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "hotelParkSoba.jpg";
		String sl4 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "hotelParkBazen.jpg";
		String sl5 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "hotelParkSala.jpg";
		slikeSmestaj1.add(sl1);
		slikeSmestaj1.add(sl2);
		slikeSmestaj1.add(sl3);
		slikeSmestaj1.add(sl4);
		slikeSmestaj1.add(sl5);
		
		List<Soba> sobe1 = Arrays.asList(s1,s2);
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
		smestaj1.setSlikeUrl(slikeSmestaj1);
		
		
		List<String> slikeSmestaj2 = new ArrayList();
		String sl21 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "apartmaniJancic.jpg";
		String sl22 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "jancicDnevna.jpg";
		
		slikeSmestaj2.add(sl21);
		slikeSmestaj2.add(sl22);

		
		List<Soba> sobe2 = Arrays.asList(s3,s4);
		Smestaj smestaj2 = new Smestaj();
		smestaj2.setId("2");
		smestaj2.setNaziv("Apartmani Jancic");
		smestaj2.setMesto("Smederevo");
		smestaj2.setAdresa("Lukijana Musickog 17");
		smestaj2.setKategorija(3);
		smestaj2.setTip(Tip.APARTMENT);
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
		smestaj2.setSlikeUrl(slikeSmestaj2);
		
		smestajRepository.deleteAll();
		
		List<Smestaj> smestaji = Arrays.asList(smestaj1,smestaj2);
		
		smestajRepository.saveAll(smestaji);
		
		ArrayList<Smestaj> smestajiAgenta = new ArrayList();
		smestajiAgenta.add(smestaj1);
		smestajiAgenta.add(smestaj2);
		
		Korisnik k1 = new Korisnik();
		k1.setId("1");
		k1.setAdresa("Milovan Jelica 32");
		k1.setIme("Marko");
		k1.setPrezime("Markovic");
		k1.setUsername("mm");
		k1.setMaticniBroj("1234567890123");
		k1.setPassword("test1234");
		k1.setUloga(Uloga.AGENT);
		
		Korisnik k2 = new Korisnik();
		k2.setId("2");
		k2.setAdresa("Milovan Jelica 32");
		k2.setIme("Pera");
		k2.setPrezime("Peric");
		k2.setUsername("pp");
		k2.setMaticniBroj("1234567890123");
		k2.setPassword("test1234");
		k2.setUloga(Uloga.USER);
		k2.setSmestaji(smestajiAgenta);
		
		Korisnik k3 = new Korisnik();
		k3.setId("3");
		k3.setAdresa("Milovan Jelica 32");
		k3.setIme("Nikola");
		k3.setPrezime("Nikolic");
		k3.setUsername("nn");
		k3.setMaticniBroj("1234567890123");
		k3.setPassword("test1234");
		k3.setUloga(Uloga.USER);
		
		
		Poruka p1 = new Poruka();
		p1.setId("1");
		p1.setNaslov("Obavestenje");
		
		GregorianCalendar gcal1 = new GregorianCalendar();
	      XMLGregorianCalendar xgcal1 = DatatypeFactory.newInstance()
	            .newXMLGregorianCalendar(gcal1);
		p1.setDatumSlanja(xgcal1);
		
		p1.setSadrzaj("Pozdrav, kasnicu jedan dan zbog problema sa automobilom.");
		p1.setProcitana(false);
		p1.setSagovornik(k2);
		p1.setPrimljena(true);
		
		Poruka p2 = new Poruka();
		p2.setId("2");
		p2.setNaslov("Bitno pitanje oko kuhinje");
		
		GregorianCalendar gcal2 = new GregorianCalendar();
	      XMLGregorianCalendar xgcal2 = DatatypeFactory.newInstance()
	            .newXMLGregorianCalendar(gcal2);
		p2.setDatumSlanja(xgcal2);
		
		p2.setSadrzaj("Pozdrav, da li postoji frizider u okviru mini kuhinje?");
		p2.setProcitana(false);
		p2.setSagovornik(k3);
		p2.setPrimljena(true);
		
		Poruka p3 = new Poruka();
		p3.setId("3");
		p3.setNaslov("Bitno pitanje oko kuhinje");
		
		GregorianCalendar gcal3 = new GregorianCalendar();
	      XMLGregorianCalendar xgcal3 = DatatypeFactory.newInstance()
	            .newXMLGregorianCalendar(gcal3);
		p3.setDatumSlanja(xgcal3);
		
		p3.setSadrzaj("Pozdrav, postoji frizider u kuhinji.");
		p3.setProcitana(false);
		p3.setSagovornik(k3);
		p3.setPrimljena(false);
		
		porukaRepository.deleteAll();
		
		List<Poruka> poruke = Arrays.asList(p1, p2, p3);
		
		porukaRepository.saveAll(poruke);
		
		korisnikRepository.deleteAll();
		
		List<Korisnik> korisnici = Arrays.asList(k1,k2,k3);
		
		korisnikRepository.saveAll(korisnici);
		
		
		
	}

}
