
package com.example.agent.demoModel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for korisnik complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="korisnik"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="smestaji" type="{http://techprimers.com/demo}smestaj" maxOccurs="unbounded"/&gt;
 *         &lt;element name="poslate_poruke" type="{http://techprimers.com/demo}poruka" maxOccurs="unbounded"/&gt;
 *         &lt;element name="primljene_poruke" type="{http://techprimers.com/demo}poruka" maxOccurs="unbounded"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="uloga" type="{http://techprimers.com/demo}uloga"/&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="maticni_broj" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="adresa" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "korisnik", propOrder = {
    "smestaji",
    "poslatePoruke",
    "primljenePoruke",
    "id",
    "ime",
    "prezime",
    "uloga",
    "username",
    "password",
    "maticniBroj",
    "adresa",
    "email"
})
public class Korisnik {

    @XmlElement(required = true)
    protected List<Smestaj> smestaji;
    @XmlElement(name = "poslate_poruke", required = true)
    protected List<Poruka> poslatePoruke;
    @XmlElement(name = "primljene_poruke", required = true)
    protected List<Poruka> primljenePoruke;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String ime;
    @XmlElement(required = true)
    protected String prezime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Uloga uloga;
    @XmlElement(required = true)
    protected String username;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(name = "maticni_broj", required = true)
    protected String maticniBroj;
    @XmlElement(required = true)
    protected String adresa;
    @XmlElement(required = true)
    protected String email;

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
     * Gets the value of the smestaji property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the smestaji property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSmestaji().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Smestaj }
     * 
     * 
     */
    public List<Smestaj> getSmestaji() {
        if (smestaji == null) {
            smestaji = new ArrayList<Smestaj>();
        }
        return this.smestaji;
    }

    /**
     * Gets the value of the poslatePoruke property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the poslatePoruke property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoslatePoruke().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Poruka }
     * 
     * 
     */
    public List<Poruka> getPoslatePoruke() {
        if (poslatePoruke == null) {
            poslatePoruke = new ArrayList<Poruka>();
        }
        return this.poslatePoruke;
    }

    /**
     * Gets the value of the primljenePoruke property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the primljenePoruke property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrimljenePoruke().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Poruka }
     * 
     * 
     */
    public List<Poruka> getPrimljenePoruke() {
        if (primljenePoruke == null) {
            primljenePoruke = new ArrayList<Poruka>();
        }
        return this.primljenePoruke;
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
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the prezime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Sets the value of the prezime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrezime(String value) {
        this.prezime = value;
    }

    /**
     * Gets the value of the uloga property.
     * 
     * @return
     *     possible object is
     *     {@link Uloga }
     *     
     */
    public Uloga getUloga() {
        return uloga;
    }

    /**
     * Sets the value of the uloga property.
     * 
     * @param value
     *     allowed object is
     *     {@link Uloga }
     *     
     */
    public void setUloga(Uloga value) {
        this.uloga = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the maticniBroj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaticniBroj() {
        return maticniBroj;
    }

    /**
     * Sets the value of the maticniBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaticniBroj(String value) {
        this.maticniBroj = value;
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

}
