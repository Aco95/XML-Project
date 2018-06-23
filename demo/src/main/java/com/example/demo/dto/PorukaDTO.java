package com.example.demo.dto;

import javax.xml.bind.annotation.XmlElement;

public class PorukaDTO {
	
	private String idKlijenta;
	private String idAgenta;
	private String naslov;
	private String sadrzaj;
	private boolean procitana;
	private boolean primljena;
	public String getIdKlijenta() {
		return idKlijenta;
	}
	public void setIdKlijenta(String idKlijenta) {
		this.idKlijenta = idKlijenta;
	}
	public String getIdAgenta() {
		return idAgenta;
	}
	public void setIdAgenta(String idAgenta) {
		this.idAgenta = idAgenta;
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
	public boolean isProcitana() {
		return procitana;
	}
	public void setProcitana(boolean procitana) {
		this.procitana = procitana;
	}
	public boolean isPrimljena() {
		return primljena;
	}
	public void setPrimljena(boolean primljena) {
		this.primljena = primljena;
	}
	public PorukaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PorukaDTO(String idKlijenta, String idAgenta, String naslov, String sadrzaj, boolean procitana,
			boolean primljena) {
		super();
		this.idKlijenta = idKlijenta;
		this.idAgenta = idAgenta;
		this.naslov = naslov;
		this.sadrzaj = sadrzaj;
		this.procitana = procitana;
		this.primljena = primljena;
	}
	
	
	

}
