
package com.example.agent.demoModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for poruka complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="poruka"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sagovornik" type="{http://techprimers.com/demo}korisnik"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="procitana" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="datum_slanja" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sadrzaj" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="primljena" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "poruka", propOrder = {
    "sagovornik",
    "id",
    "procitana",
    "datumSlanja",
    "naslov",
    "sadrzaj",
    "primljena"
})
public class Poruka {

    @XmlElement(required = true)
    protected Korisnik sagovornik;
    @XmlElement(required = true)
    protected String id;
    protected boolean procitana;
    @XmlElement(name = "datum_slanja", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumSlanja;
    @XmlElement(required = true)
    protected String naslov;
    @XmlElement(required = true)
    protected String sadrzaj;
    protected boolean primljena;

    /**
     * Gets the value of the sagovornik property.
     * 
     * @return
     *     possible object is
     *     {@link Korisnik }
     *     
     */
    public Korisnik getSagovornik() {
        return sagovornik;
    }

    /**
     * Sets the value of the sagovornik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Korisnik }
     *     
     */
    public void setSagovornik(Korisnik value) {
        this.sagovornik = value;
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
     * Gets the value of the procitana property.
     * 
     */
    public boolean isProcitana() {
        return procitana;
    }

    /**
     * Sets the value of the procitana property.
     * 
     */
    public void setProcitana(boolean value) {
        this.procitana = value;
    }

    /**
     * Gets the value of the datumSlanja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumSlanja() {
        return datumSlanja;
    }

    /**
     * Sets the value of the datumSlanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumSlanja(XMLGregorianCalendar value) {
        this.datumSlanja = value;
    }

    /**
     * Gets the value of the naslov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Sets the value of the naslov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaslov(String value) {
        this.naslov = value;
    }

    /**
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSadrzaj(String value) {
        this.sadrzaj = value;
    }

    /**
     * Gets the value of the primljena property.
     * 
     */
    public boolean isPrimljena() {
        return primljena;
    }

    /**
     * Sets the value of the primljena property.
     * 
     */
    public void setPrimljena(boolean value) {
        this.primljena = value;
    }

}
