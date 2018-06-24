
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
 *         &lt;element name="soba" type="{http://techprimers.com/demo}soba"/&gt;
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
    "soba"
})
@XmlRootElement(name = "getSobaResponse")
public class GetSobaResponse {

    @XmlElement(required = true)
    protected Soba soba;

    /**
     * Gets the value of the soba property.
     * 
     * @return
     *     possible object is
     *     {@link Soba }
     *     
     */
    public Soba getSoba() {
        return soba;
    }

    /**
     * Sets the value of the soba property.
     * 
     * @param value
     *     allowed object is
     *     {@link Soba }
     *     
     */
    public void setSoba(Soba value) {
        this.soba = value;
    }

}
