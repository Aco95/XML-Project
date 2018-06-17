package com.example.demo.dto;

import javax.xml.bind.annotation.XmlAttribute;

import com.example.demo.entities.Uloga;

public class AgentRegisterDto {

    @XmlAttribute(name = "ime")
    protected String ime;
    @XmlAttribute(name = "prezime")
    protected String prezime;
    @XmlAttribute(name = "username")
    protected String username;
    @XmlAttribute(name = "maticni_broj")
    protected String maticniBroj;
    @XmlAttribute(name = "adresa")
    protected String adresa;
    @XmlAttribute(name = "email")
    protected String email;    
    @XmlAttribute(name = "password")
    protected String password;
      
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMaticniBroj() {
		return maticniBroj;
	}
	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
    
}
