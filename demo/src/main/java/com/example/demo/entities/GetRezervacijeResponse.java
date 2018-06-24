
package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="rezervacije" type="{http://techprimers.com/demo}rezervacija" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "rezervacije"
})
@XmlRootElement(name = "getRezervacijeResponse")
public class GetRezervacijeResponse {

    protected List<Rezervacija> rezervacije;

    /**
     * Gets the value of the rezervacije property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rezervacije property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRezervacije().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rezervacija }
     * 
     * 
     */
    public List<Rezervacija> getRezervacije() {
        if (rezervacije == null) {
            rezervacije = new ArrayList<Rezervacija>();
        }
        return this.rezervacije;
    }

	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

}
