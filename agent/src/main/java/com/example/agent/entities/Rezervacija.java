package com.example.agent.entities;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "rezervacija")
@Document(collection="Rezervacije")
public class Rezervacija {

	@Id
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "od")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar od;
    @XmlAttribute(name = "do")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar _do;
    @XmlAttribute(name = "id_sobe")
    protected String idSobe;
    @XmlAttribute(name = "id_Korisnika")
    protected String idKorisnika;
    @XmlAttribute(name = "realizacija")
    protected Realizacija realizacija;
    
    
	
	public Realizacija getRealizacija() {
		return realizacija;
	}
	public void setRealizacija(Realizacija realizacija) {
		this.realizacija = realizacija;
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
	public String getIdSobe() {
		return idSobe;
	}
	public void setIdSobe(String idSobe) {
		this.idSobe = idSobe;
	}
	public String getIdKorisnika() {
		return idKorisnika;
	}
	public void setIdKorisnika(String idKorisnika) {
		this.idKorisnika = idKorisnika;
	}
	
	
	
	public Rezervacija(String id, XMLGregorianCalendar od, XMLGregorianCalendar _do, String idSobe, String idKorisnika,
			Realizacija realizacija) {
		super();
		this.id = id;
		this.od = od;
		this._do = _do;
		this.idSobe = idSobe;
		this.idKorisnika = idKorisnika;
		this.realizacija = realizacija;
	}
	public Rezervacija() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
