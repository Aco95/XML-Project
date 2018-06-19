package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Korisnik;
import com.example.demo.entities.Smestaj;
import com.example.demo.entities.Soba;
import com.example.demo.entities.Tip;
import com.example.demo.entities.Uloga;
import com.example.demo.entities.Rezervacija;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.RezervacijaRepository;
import com.example.demo.repository.SmestajRepository;
import com.example.demo.repository.SobaRepository;


@Component
public class DbSeeder implements CommandLineRunner{
	
	@Autowired
	private AdminRepository korisnikRepository;
	
	@Autowired
	private SobaRepository sobaRepository;
	
	@Autowired
	private SmestajRepository smestajRepository;
	
	@Autowired
	private RezervacijaRepository rezervacijaRepository;
	
	

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
		k1.setEmail("email@email");
		k1.setPassword("$2a$10$wws6XE7uyO2I23B355XXlOBnV/fSgU2GANadnkxAF3uWQ.7lYqMHS");
		k1.setUloga(Uloga.ADMIN);
		k1.setBlokiran(false);
		
		
		Korisnik k2 = new Korisnik();
		k2.setId("2");
		k2.setAdresa("Milovan Jelica 32");
		k2.setIme("Pera");
		k2.setPrezime("Peric");
		k2.setUsername("pp");
		k2.setMaticniBroj("1234567890123");
		k2.setPassword("test1234");
		k2.setEmail("email@email");
		k2.setPassword("$2a$10$wws6XE7uyO2I23B355XXlOBnV/fSgU2GANadnkxAF3uWQ.7lYqMHS");
		k2.setUloga(Uloga.AGENT);
		k2.setBlokiran(true);
		
		Korisnik k3 = new Korisnik();
		k3.setId("3");
		k3.setAdresa("Milovan Jelica 32");
		k3.setIme("Nikola");
		k3.setPrezime("Nikolic");
		k3.setUsername("nn");
		k3.setMaticniBroj("1234567890123");
		k3.setPassword("test1234");
		k3.setEmail("email@email");
		k3.setPassword("$2a$10$wws6XE7uyO2I23B355XXlOBnV/fSgU2GANadnkxAF3uWQ.7lYqMHS");
		k3.setUloga(Uloga.USER);
		k3.setRezervacije(new ArrayList<Rezervacija>());
		
		Korisnik k4 = new Korisnik();
		k4.setId("4");
		k4.setAdresa("Milovan Jelica 32");
		k4.setIme("Bosko");
		k4.setPrezime("Boskovic");
		k4.setUsername("bb");
		k4.setMaticniBroj("1234567890123");
		k4.setPassword("bolebena");
		k4.setEmail("bole@email");
		k4.setPassword("$2a$10$wws6XE7uyO2I23B355XXlOBnV/fSgU2GANadnkxAF3uWQ.7lYqMHS");
		k4.setUloga(Uloga.USER);
		k4.setRezervacije(new ArrayList<Rezervacija>());
		
		
		// -------------------------- sobe za Hotel Park --------------------------------//
		Soba s1 = new Soba();
		s1.setId("1");
		s1.setBroj(1);
		s1.setKapacitet(1); 	// jednokrevetna
		s1.setRezervacije(new ArrayList<Rezervacija>());		// bez rezervacija
		s1.setIdSmestaja("1");
		s1.setCena(100);
		
		Soba s5 = new Soba();
		s5.setId("5");
		s5.setBroj(5);
		s5.setKapacitet(2); 	// dvokrevetna
		s5.setCena(200);
		ArrayList<Rezervacija> rezervacijeZaSobu5 = new ArrayList<Rezervacija>();
		Rezervacija rez51 = new Rezervacija();
		rez51.setId("1");
		rez51.setIdSobe("5");
		rez51.setOd(DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-07-04"));
		rez51.setDo(DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-07-12"));
		rez51.setidKorisnika("3");
		k3.getRezervacije().add(rez51);
		rezervacijeZaSobu5.add(rez51);
		Rezervacija rez52 = new Rezervacija();
		rez52.setId("2");
		rez52.setIdSobe("5");
		rez52.setOd(DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-08-10"));
		rez52.setDo(DatatypeFactory.newInstance().newXMLGregorianCalendar("2018-08-20"));
		rez52.setidKorisnika("4");
		k4.getRezervacije().add(rez52);
		rezervacijeZaSobu5.add(rez52);
		
		
		s5.setRezervacije(rezervacijeZaSobu5);
		s5.setIdSmestaja("1");
		
		Soba s6 = new Soba();
		s6.setId("6");
		s6.setBroj(6);
		s6.setKapacitet(3); 	// trokrevetna
		s6.setRezervacije(new ArrayList<Rezervacija>());		// bez rezervacija
		s6.setIdSmestaja("1");
		s6.setCena(300);
		
		Soba s13 = new Soba();
		s13.setId("13");
		s13.setBroj(13);
		s13.setKapacitet(3); 	// trokrevetna
		s13.setRezervacije(new ArrayList<Rezervacija>());		// bez rezervacija
		s13.setIdSmestaja("1");
		s13.setCena(350);
		
		Soba s7 = new Soba();
		s7.setId("7");
		s7.setBroj(7);
		s7.setKapacitet(4); 	// cetvorokrevetna
		s7.setRezervacije(new ArrayList<Rezervacija>());		// bez rezervacija
		s7.setIdSmestaja("1");	
		s7.setCena(400);
		// -----------------------------------------------------------------------//
		
		
		// -------------------------- sobe za apartmane Jancic --------------------------------//
		Soba s3 = new Soba();
		s3.setId("3");
		s3.setBroj(3);
		s3.setKapacitet(3); 	// trokrevetna
		s3.setRezervacije(new ArrayList<Rezervacija>());		// bez rezervacija
		s3.setIdSmestaja("2");
		s3.setCena(300);
		
		Soba s4 = new Soba();
		s4.setId("4");
		s4.setBroj(4);
		s4.setKapacitet(4); 	// cetvorokrevetna
		s4.setRezervacije(new ArrayList<Rezervacija>());		// bez rezervacija
		s4.setIdSmestaja("2");
		s4.setCena(400);
		
		Soba s8 = new Soba();
		s8.setId("8");
		s8.setBroj(8);
		s8.setKapacitet(1); 	// jednokrevetna
		s8.setRezervacije(new ArrayList<Rezervacija>());		// bez rezervacija
		s8.setIdSmestaja("2");
		s8.setCena(100);
		
		Soba s9 = new Soba();
		s9.setId("8");
		s9.setBroj(8);
		s9.setKapacitet(2); 	// dvokrevetna
		s9.setRezervacije(new ArrayList<Rezervacija>());		// bez rezervacija
		s9.setIdSmestaja("2");
		s9.setCena(200);
		// ---------------------------------------------------------------------------------//
		
		
		// -------------------------- sobe za Hotel Aleksandar --------------------------------//
		Soba s2 = new Soba();
		s2.setId("2");
		s2.setBroj(2);
		s2.setKapacitet(1); 	// jednokrevetna
		s2.setRezervacije(new ArrayList<Rezervacija>());		// bez rezervacija
		s2.setIdSmestaja("3");
		s2.setCena(100);
		
		Soba s10 = new Soba();
		s10.setId("10");
		s10.setBroj(10);
		s10.setKapacitet(2); 	// dvokrevetna
		s10.setRezervacije(new ArrayList<Rezervacija>());		// bez rezervacija
		s10.setIdSmestaja("3");
		s10.setCena(200);
		
		Soba s11 = new Soba();
		s11.setId("11");
		s11.setBroj(11);
		s11.setKapacitet(3); 	// trokrevetna
		s11.setRezervacije(new ArrayList<Rezervacija>());		// bez rezervacija
		s11.setIdSmestaja("3");
		s11.setCena(300);
		
		Soba s12 = new Soba();
		s12.setId("12");
		s12.setBroj(12);
		s12.setKapacitet(4); 	// cetvorokrevetna
		s12.setRezervacije(new ArrayList<Rezervacija>());		// bez rezervacija
		s12.setIdSmestaja("3");
		s12.setCena(400);
		// -----------------------------------------------------------------------------------//
		
		rezervacijaRepository.deleteAll();	
		List<Rezervacija> reze = Arrays.asList(rez51,rez52);		
		rezervacijaRepository.saveAll(reze);
		
		
		korisnikRepository.deleteAll();
		List<Korisnik> korisnici = Arrays.asList(k1,k2,k3,k4);
		korisnikRepository.saveAll(korisnici);
		
		
		sobaRepository.deleteAll();	
		List<Soba> sobe = Arrays.asList(s1,s2,s3,s4,s5,s7,s8,s9,s10,s11,s12,s13);		
		sobaRepository.saveAll(sobe);
	
		
		
		List<Soba> sobe1 = Arrays.asList(s1,s5,s6,s13,s7);
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
		smestaj1.setSlikeUrl(slikeSmestaj1);
		smestaj1.setParking(true);
		smestaj1.setWifi(true);
		smestaj1.setPansion(true);
		smestaj1.setDorucak(true);
		smestaj1.setPolupansion(true);
		smestaj1.setMiniKuhinja(true);
		smestaj1.setPrivatnoKupatilo(true);
		smestaj1.setTv(true);
		
		
		List<Soba> sobe2 = Arrays.asList(s3,s4,s8,s9);
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
		List<String> slikeSmestaj2 = new ArrayList();
		String sl21 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "apartmaniJancic.jpg";
		String sl22 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "jancicDnevna.jpg";
		slikeSmestaj2.add(sl21);
		slikeSmestaj2.add(sl22);
		smestaj2.setSlikeUrl(slikeSmestaj2);
		smestaj2.setParking(false);
		smestaj2.setWifi(true);
		smestaj2.setPansion(false);
		smestaj2.setDorucak(true);
		smestaj2.setPolupansion(true);
		smestaj2.setMiniKuhinja(true);
		smestaj2.setPrivatnoKupatilo(true);
		smestaj2.setTv(true);
		
		
		List<Soba> sobe3 = Arrays.asList(s2,s10,s11,s12);
		Smestaj smestaj3 = new Smestaj();
		smestaj3.setId("3");
		smestaj3.setNaziv("Hotel Aleksandar");
		smestaj3.setMesto("Novi Sad");
		smestaj3.setAdresa("Bulevar Cara Lazara 104");
		smestaj3.setKategorija(5);
		smestaj3.setTip(Tip.HOTEL);
		smestaj3.setOcena(8.8);
		smestaj3.setOpis("Eksluzivan hotel sa limana..");
		smestaj3.setSobe(sobe3);
		List<String> slikeSmestaj3 = new ArrayList();
		String sl31 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "HotelAleksandar1.jpg";
		String sl32 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "HotelAleksandar2.jpg";
		String sl33 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "HotelAleksandar3.jpg";
		String sl34 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "HotelAleksandar4.jpg";
		String sl35 = ".." + "/" + ".." + "/" + ".." + "/" + "assets" + "/" + "images" + "/" + "HotelAleksandar5.jpg";
		slikeSmestaj3.add(sl31);
		slikeSmestaj3.add(sl32);
		slikeSmestaj3.add(sl33);
		slikeSmestaj3.add(sl34);
		slikeSmestaj3.add(sl35);
		smestaj3.setSlikeUrl(slikeSmestaj3);
		smestaj3.setParking(true);
		smestaj3.setWifi(true);
		smestaj3.setPansion(false);
		smestaj3.setDorucak(true);
		smestaj3.setPolupansion(false);
		smestaj3.setMiniKuhinja(true);
		smestaj3.setPrivatnoKupatilo(true);
		smestaj3.setTv(true);
		
		 
		smestajRepository.deleteAll();
		List<Smestaj> smestaji = Arrays.asList(smestaj1,smestaj2,smestaj3);
		smestajRepository.saveAll(smestaji);
		
	}

}
