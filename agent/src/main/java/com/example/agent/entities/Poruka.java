package com.example.agent.entities;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "poruka")
@Document(collection = "Poruke")
public class Poruka {

	@Id
	@XmlAttribute(name = "id")
	protected String id;
	
	@XmlAttribute(name = "procitana")
	protected Boolean procitana;
	@XmlAttribute(name = "datum_slanja")
	protected XMLGregorianCalendar datumSlanja;
	@XmlElement(required = true, name = "sagovornik")
	protected Korisnik sagovornik;
	@XmlAttribute(name = "naslov")
	protected String naslov;
	@XmlAttribute(name = "sadrzaj")
	protected String sadrzaj;
	@XmlAttribute(name = "primljena")
	protected Boolean primljena;

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

	public XMLGregorianCalendar getDatumSlanja() {
		return datumSlanja;
	}

	public void setDatumSlanja(XMLGregorianCalendar datumSlanja) {
		this.datumSlanja = datumSlanja;
	}

	public Korisnik getSagovornik() {
		return sagovornik;
	}

	public void setSagovornik(Korisnik sagovornik) {
		this.sagovornik = sagovornik;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	
	public Boolean getPrimljena() {
		return primljena;
	}

	public void setPrimljena(Boolean primljena) {
		this.primljena = primljena;
	}

	public Poruka() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Poruka(String id, Boolean procitana, XMLGregorianCalendar datumSlanja, Korisnik sagovornik, String naslov,
			String sadrzaj, Boolean primljena) {
		super();
		this.id = id;
		this.procitana = procitana;
		this.datumSlanja = datumSlanja;
		this.sagovornik = sagovornik;
		this.naslov = naslov;
		this.sadrzaj = sadrzaj;
		this.primljena = primljena;
	}

	

}
