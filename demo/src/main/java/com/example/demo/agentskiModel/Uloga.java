
package com.example.demo.agentskiModel;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for uloga.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="uloga"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="USER"/&gt;
 *     &lt;enumeration value="AGENT"/&gt;
 *     &lt;enumeration value="ADMIN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "uloga")
@XmlEnum
public enum Uloga {

    USER,
    AGENT,
    ADMIN;

    public String value() {
        return name();
    }

    public static Uloga fromValue(String v) {
        return valueOf(v);
    }

}
