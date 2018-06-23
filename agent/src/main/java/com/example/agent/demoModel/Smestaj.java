
package com.example.agent.demoModel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for smestaj complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="smestaj"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sobe" type="{http://techprimers.com/demo}soba" maxOccurs="unbounded"/&gt;
 *         &lt;element name="slike_url" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="adresa" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="kategorija" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tip" type="{http://techprimers.com/demo}tip"/&gt;
 *         &lt;element name="parking" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="wifi" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="dorucak" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="polupansion" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="pansion" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="tv" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="mini_kuhinja" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="privatno_kupatilo" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="ocena" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="opis" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "smestaj", propOrder = {
    "sobe",
    "slikeUrl",
    "id",
    "naziv",
    "adresa",
    "mesto",
    "kategorija",
    "tip",
    "parking",
    "wifi",
    "dorucak",
    "polupansion",
    "pansion",
    "tv",
    "miniKuhinja",
    "privatnoKupatilo",
    "ocena",
    "opis"
})
public class Smestaj {

    @XmlElement(required = true)
    protected List<Soba> sobe;
    @XmlElement(name = "slike_url")
    protected List<String> slikeUrl;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String naziv;
    @XmlElement(required = true)
    protected String adresa;
    @XmlElement(required = true)
    protected String mesto;
    protected int kategorija;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Tip tip;
    protected boolean parking;
    protected boolean wifi;
    protected boolean dorucak;
    protected boolean polupansion;
    protected boolean pansion;
    protected boolean tv;
    @XmlElement(name = "mini_kuhinja")
    protected boolean miniKuhinja;
    @XmlElement(name = "privatno_kupatilo")
    protected boolean privatnoKupatilo;
    protected double ocena;
    @XmlElement(required = true)
    protected String opis;

    /**
     * Gets the value of the sobe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sobe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSobe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Soba }
     * 
     * 
     */
    public List<Soba> getSobe() {
        if (sobe == null) {
            sobe = new ArrayList<Soba>();
        }
        return this.sobe;
    }

    public void setSobe(List<Soba> sobe) {
		this.sobe = sobe;
	}

	public void setSlikeUrl(List<String> slikeUrl) {
		this.slikeUrl = slikeUrl;
	}

	/**
     * Gets the value of the slikeUrl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slikeUrl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSlikeUrl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSlikeUrl() {
        if (slikeUrl == null) {
            slikeUrl = new ArrayList<String>();
        }
        return this.slikeUrl;
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
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
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
     * Gets the value of the mesto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesto(String value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the kategorija property.
     * 
     */
    public int getKategorija() {
        return kategorija;
    }

    /**
     * Sets the value of the kategorija property.
     * 
     */
    public void setKategorija(int value) {
        this.kategorija = value;
    }

    /**
     * Gets the value of the tip property.
     * 
     * @return
     *     possible object is
     *     {@link Tip }
     *     
     */
    public Tip getTip() {
        return tip;
    }

    /**
     * Sets the value of the tip property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tip }
     *     
     */
    public void setTip(Tip value) {
        this.tip = value;
    }

    /**
     * Gets the value of the parking property.
     * 
     */
    public boolean isParking() {
        return parking;
    }

    /**
     * Sets the value of the parking property.
     * 
     */
    public void setParking(boolean value) {
        this.parking = value;
    }

    /**
     * Gets the value of the wifi property.
     * 
     */
    public boolean isWifi() {
        return wifi;
    }

    /**
     * Sets the value of the wifi property.
     * 
     */
    public void setWifi(boolean value) {
        this.wifi = value;
    }

    /**
     * Gets the value of the dorucak property.
     * 
     */
    public boolean isDorucak() {
        return dorucak;
    }

    /**
     * Sets the value of the dorucak property.
     * 
     */
    public void setDorucak(boolean value) {
        this.dorucak = value;
    }

    /**
     * Gets the value of the polupansion property.
     * 
     */
    public boolean isPolupansion() {
        return polupansion;
    }

    /**
     * Sets the value of the polupansion property.
     * 
     */
    public void setPolupansion(boolean value) {
        this.polupansion = value;
    }

    /**
     * Gets the value of the pansion property.
     * 
     */
    public boolean isPansion() {
        return pansion;
    }

    /**
     * Sets the value of the pansion property.
     * 
     */
    public void setPansion(boolean value) {
        this.pansion = value;
    }

    /**
     * Gets the value of the tv property.
     * 
     */
    public boolean isTv() {
        return tv;
    }

    /**
     * Sets the value of the tv property.
     * 
     */
    public void setTv(boolean value) {
        this.tv = value;
    }

    /**
     * Gets the value of the miniKuhinja property.
     * 
     */
    public boolean isMiniKuhinja() {
        return miniKuhinja;
    }

    /**
     * Sets the value of the miniKuhinja property.
     * 
     */
    public void setMiniKuhinja(boolean value) {
        this.miniKuhinja = value;
    }

    /**
     * Gets the value of the privatnoKupatilo property.
     * 
     */
    public boolean isPrivatnoKupatilo() {
        return privatnoKupatilo;
    }

    /**
     * Sets the value of the privatnoKupatilo property.
     * 
     */
    public void setPrivatnoKupatilo(boolean value) {
        this.privatnoKupatilo = value;
    }

    /**
     * Gets the value of the ocena property.
     * 
     */
    public double getOcena() {
        return ocena;
    }

    /**
     * Sets the value of the ocena property.
     * 
     */
    public void setOcena(double value) {
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

}
