
package com.example.agent.demoModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="smestaj" type="{http://techprimers.com/demo}rezervacija"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rezervacija"
})
@XmlRootElement(name = "addRezervacijaResponse")
public class AddRezervacijaResponse {

    @XmlElement(required = true)
    protected Rezervacija rezervacija;

	public Rezervacija getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}

    /**
     * Gets the value of the smestaj property.
     * 
     * @return
     *     possible object is
     *     {@link Rezervacija }
     *     
     */
    

    /**
     * Sets the value of the smestaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rezervacija }
     *     
     */
    

}
