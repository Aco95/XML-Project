package com.example.agent.dtos;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.data.annotation.Id;

import com.example.agent.entities.Korisnik;
import com.example.agent.entities.Realizacija;
import com.example.agent.entities.Smestaj;
import com.example.agent.entities.Soba;


public class RezervacijaDTO {


    private String id;

    private XMLGregorianCalendar od;

    private XMLGregorianCalendar _do;

    private Soba soba;

    private Korisnik klijent;

    private Smestaj smestaj;
    
    private Realizacija realizacija;
    
    
    
	public Realizacija getRealizacija() {
		return realizacija;
	}

	public void setRealizacija(Realizacija realizacija) {
		this.realizacija = realizacija;
	}

	public Smestaj getSmestaj() {
		return smestaj;
	}

	public void setSmestaj(Smestaj smestaj) {
		this.smestaj = smestaj;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public XMLGregorianCalendar getOd() {
		return od;
	}

	public void setOd(XMLGregorianCalendar od) {
		this.od = od;
	}

	public XMLGregorianCalendar get_do() {
		return _do;
	}

	public void set_do(XMLGregorianCalendar _do) {
		this._do = _do;
	}

	public Soba getSoba() {
		return soba;
	}

	public void setSoba(Soba soba) {
		this.soba = soba;
	}

	public Korisnik getKlijent() {
		return klijent;
	}

	public void setKlijent(Korisnik klijent) {
		this.klijent = klijent;
	}

	

	

	public RezervacijaDTO(String id, XMLGregorianCalendar od, XMLGregorianCalendar _do, Soba soba, Korisnik klijent,
			Smestaj smestaj, Realizacija realizacija) {
		super();
		this.id = id;
		this.od = od;
		this._do = _do;
		this.soba = soba;
		this.klijent = klijent;
		this.smestaj = smestaj;
		this.realizacija = realizacija;
	}

	public RezervacijaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
