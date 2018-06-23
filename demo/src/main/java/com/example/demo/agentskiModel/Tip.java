
package com.example.demo.agentskiModel;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tip.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tip"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="HOTEL"/&gt;
 *     &lt;enumeration value="BED_BREAKFAST"/&gt;
 *     &lt;enumeration value="APARTMENT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "tip")
@XmlEnum
public enum Tip {

    HOTEL,
    BED_BREAKFAST,
    APARTMENT;

    public String value() {
        return name();
    }

    public static Tip fromValue(String v) {
        return valueOf(v);
    }

}
