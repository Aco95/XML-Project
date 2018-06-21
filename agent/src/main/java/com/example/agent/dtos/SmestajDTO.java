package com.example.agent.dtos;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.example.agent.entities.Soba;
import com.example.agent.entities.Tip;



public class SmestajDTO {

	private List<Soba> sobe;
	private List<String> slikeUrl;
    
	private String id;
	private String naziv;
	private String adresa;
	private String mesto;
	private Integer kategorija;
	private Tip tip;
	private Boolean parking;
	private Boolean wifi;
	private Boolean dorucak;
	private Boolean polupansion;
	private Boolean pansion;
	private Boolean tv;
	private Boolean miniKuhinja;
	private Boolean privatnoKupatilo;
	private double ocena;
	private String opis;
	private int brJednokrevetnih;
	private int brDvokrevetnih;
	private int brTrokrevetnih;
	private int brCetvorokrevetnih;
	
	

	public SmestajDTO(List<Soba> sobe, List<String> slikeUrl, String id, String naziv, String adresa, String mesto,
			Integer kategorija, Tip tip, Boolean parking, Boolean wifi, Boolean dorucak, Boolean polupansion,
			Boolean pansion, Boolean tv, Boolean miniKuhinja, Boolean privatnoKupatilo, double ocena, String opis,
			int brJednokrevetnih, int brDvokrevetnih, int brTrokrevetnih, int brCetvorokrevetnih) {
		super();
		this.sobe = sobe;
		this.slikeUrl = slikeUrl;
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.mesto = mesto;
		this.kategorija = kategorija;
		this.tip = tip;
		this.parking = parking;
		this.wifi = wifi;
		this.dorucak = dorucak;
		this.polupansion = polupansion;
		this.pansion = pansion;
		this.tv = tv;
		this.miniKuhinja = miniKuhinja;
		this.privatnoKupatilo = privatnoKupatilo;
		this.ocena = ocena;
		this.opis = opis;
		this.brJednokrevetnih = brJednokrevetnih;
		this.brDvokrevetnih = brDvokrevetnih;
		this.brTrokrevetnih = brTrokrevetnih;
		this.brCetvorokrevetnih = brCetvorokrevetnih;
	}

	public SmestajDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Soba> getSobe() {
		return sobe;
	}

	public void setSobe(List<Soba> sobe) {
		this.sobe = sobe;
	}

	public List<String> getSlikeUrl() {
		return slikeUrl;
	}

	public void setSlikeUrl(List<String> slikeUrl) {
		this.slikeUrl = slikeUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public Integer getKategorija() {
		return kategorija;
	}

	public void setKategorija(Integer kategorija) {
		this.kategorija = kategorija;
	}

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}

	public Boolean getParking() {
		return parking;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public Boolean getWifi() {
		return wifi;
	}

	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}

	public Boolean getDorucak() {
		return dorucak;
	}

	public void setDorucak(Boolean dorucak) {
		this.dorucak = dorucak;
	}

	public Boolean getPolupansion() {
		return polupansion;
	}

	public void setPolupansion(Boolean polupansion) {
		this.polupansion = polupansion;
	}

	public Boolean getPansion() {
		return pansion;
	}

	public void setPansion(Boolean pansion) {
		this.pansion = pansion;
	}

	public Boolean getTv() {
		return tv;
	}

	public void setTv(Boolean tv) {
		this.tv = tv;
	}

	public Boolean getMiniKuhinja() {
		return miniKuhinja;
	}

	public void setMiniKuhinja(Boolean miniKuhinja) {
		this.miniKuhinja = miniKuhinja;
	}

	public Boolean getPrivatnoKupatilo() {
		return privatnoKupatilo;
	}

	public void setPrivatnoKupatilo(Boolean privatnoKupatilo) {
		this.privatnoKupatilo = privatnoKupatilo;
	}

	public double getOcena() {
		return ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getBrJednokrevetnih() {
		return brJednokrevetnih;
	}

	public void setBrJednokrevetnih(int brJednokrevetnih) {
		this.brJednokrevetnih = brJednokrevetnih;
	}

	public int getBrDvokrevetnih() {
		return brDvokrevetnih;
	}

	public void setBrDvokrevetnih(int brDvokrevetnih) {
		this.brDvokrevetnih = brDvokrevetnih;
	}

	public int getBrTrokrevetnih() {
		return brTrokrevetnih;
	}

	public void setBrTrokrevetnih(int brTrokrevetnih) {
		this.brTrokrevetnih = brTrokrevetnih;
	}

	public int getBrCetvorokrevetnih() {
		return brCetvorokrevetnih;
	}

	public void setBrCetvorokrevetnih(int brCetvorokrevetnih) {
		this.brCetvorokrevetnih = brCetvorokrevetnih;
	}
	
	
	
	
}
