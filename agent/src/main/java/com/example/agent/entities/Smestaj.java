//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.12 at 01:29:48 AM CEST 
//


package com.example.agent.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element ref="{}soba"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="adresa" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="kategorija" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tip" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="parking" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="wifi" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="dorucak" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="polupansion" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="pansion" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="tv" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="mini_kuhinja" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="privatno_kupatilo" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ocena" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="opis" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cena" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "soba"
})
@XmlRootElement(name = "smestaj")
@Document(collection="Smestaji")
public class Smestaj {

    @XmlElement(required = true)
    protected List<Soba> soba;
    
    @Id
    @XmlAttribute(name = "id")
    protected String id;
    
    @XmlAttribute(name = "adresa")
    protected String adresa;
    @XmlAttribute(name = "kategorija")
    protected String kategorija;
    @XmlAttribute(name = "tip")
    protected Integer tip;
    @XmlAttribute(name = "parking")
    protected Boolean parking;
    @XmlAttribute(name = "wifi")
    protected Boolean wifi;
    @XmlAttribute(name = "dorucak")
    protected Boolean dorucak;
    @XmlAttribute(name = "polupansion")
    protected Boolean polupansion;
    @XmlAttribute(name = "pansion")
    protected Boolean pansion;
    @XmlAttribute(name = "tv")
    protected Boolean tv;
    @XmlAttribute(name = "mini_kuhinja")
    protected Boolean miniKuhinja;
    @XmlAttribute(name = "privatno_kupatilo")
    protected Boolean privatnoKupatilo;
    @XmlAttribute(name = "ocena")
    protected Integer ocena;
    @XmlAttribute(name = "opis")
    protected String opis;
    @XmlAttribute(name = "cena")
    protected String cena;
    @XmlAttribute(name = "url")
    protected String url;

    /**
     * Gets the value of the soba property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soba property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoba().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Soba }
     * 
     * 
     */
    public List<Soba> getSoba() {
        if (soba == null) {
            soba = new ArrayList<Soba>();
        }
        return this.soba;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresa(String value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the kategorija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKategorija() {
        return kategorija;
    }

    /**
     * Sets the value of the kategorija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKategorija(String value) {
        this.kategorija = value;
    }

    /**
     * Gets the value of the tip property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTip() {
        return tip;
    }

    /**
     * Sets the value of the tip property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTip(Integer value) {
        this.tip = value;
    }

    /**
     * Gets the value of the parking property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isParking() {
        return parking;
    }

    /**
     * Sets the value of the parking property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setParking(Boolean value) {
        this.parking = value;
    }

    /**
     * Gets the value of the wifi property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWifi() {
        return wifi;
    }

    /**
     * Sets the value of the wifi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWifi(Boolean value) {
        this.wifi = value;
    }

    /**
     * Gets the value of the dorucak property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDorucak() {
        return dorucak;
    }

    /**
     * Sets the value of the dorucak property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDorucak(Boolean value) {
        this.dorucak = value;
    }

    /**
     * Gets the value of the polupansion property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPolupansion() {
        return polupansion;
    }

    /**
     * Sets the value of the polupansion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPolupansion(Boolean value) {
        this.polupansion = value;
    }

    /**
     * Gets the value of the pansion property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPansion() {
        return pansion;
    }

    /**
     * Sets the value of the pansion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPansion(Boolean value) {
        this.pansion = value;
    }

    /**
     * Gets the value of the tv property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTv() {
        return tv;
    }

    /**
     * Sets the value of the tv property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTv(Boolean value) {
        this.tv = value;
    }

    /**
     * Gets the value of the miniKuhinja property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMiniKuhinja() {
        return miniKuhinja;
    }

    /**
     * Sets the value of the miniKuhinja property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMiniKuhinja(Boolean value) {
        this.miniKuhinja = value;
    }

    /**
     * Gets the value of the privatnoKupatilo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPrivatnoKupatilo() {
        return privatnoKupatilo;
    }

    /**
     * Sets the value of the privatnoKupatilo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPrivatnoKupatilo(Boolean value) {
        this.privatnoKupatilo = value;
    }

    /**
     * Gets the value of the ocena property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOcena() {
        return ocena;
    }

    /**
     * Sets the value of the ocena property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOcena(Integer value) {
        this.ocena = value;
    }

    /**
     * Gets the value of the opis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Sets the value of the opis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpis(String value) {
        this.opis = value;
    }

    /**
     * Gets the value of the cena property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCena() {
        return cena;
    }

    /**
     * Sets the value of the cena property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCena(String value) {
        this.cena = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

	public Smestaj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Smestaj(List<Soba> soba, String adresa, String kategorija, Integer tip, Boolean parking, Boolean wifi,
			Boolean dorucak, Boolean polupansion, Boolean pansion, Boolean tv, Boolean miniKuhinja,
			Boolean privatnoKupatilo, Integer ocena, String opis, String cena, String url) {
		super();
		this.soba = soba;
		this.adresa = adresa;
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
		this.cena = cena;
		this.url = url;
	}
    
    
    

}