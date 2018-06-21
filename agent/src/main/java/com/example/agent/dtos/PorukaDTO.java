package com.example.agent.dtos;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.data.annotation.Id;

import com.example.agent.entities.Korisnik;

public class PorukaDTO {


	private String id;
	private Boolean procitana;
	private String sagovornik;
	private String naslov;
	private String sadrzaj;
	private Boolean primljena;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getProcitana() {
		return procitana;
	}
	public void setProcitana(Boolean procitana) {
		this.procitana = procitana;
	}
	public String getSagovornik() {
		return sagovornik;
	}
	public void setSagovornik(String sagovornik) {
		this.sagovornik = sagovornik;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getSadrzaj() {
		return sadrzaj;
	}
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}
	public Boolean getPrimljena() {
		return primljena;
	}
	public void setPrimljena(Boolean primljena) {
		this.primljena = primljena;
	}
	public PorukaDTO(String id, Boolean procitana, String sagovornik, String naslov, String sadrzaj,
			Boolean primljena) {
		super();
		this.id = id;
		this.procitana = procitana;
		this.sagovornik = sagovornik;
		this.naslov = naslov;
		this.sadrzaj = sadrzaj;
		this.primljena = primljena;
	}
	public PorukaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
