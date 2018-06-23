
package com.example.demo.agentskiModel;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for realizacija.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="realizacija"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="REALIZED"/&gt;
 *     &lt;enumeration value="UNREALIZED"/&gt;
 *     &lt;enumeration value="WAITING_TO_CHECK_IN"/&gt;
 *     &lt;enumeration value="WAITING_TO_CONFIRM_REALIZATION"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "realizacija")
@XmlEnum
public enum Realizacija {

    REALIZED,
    UNREALIZED,
    WAITING_TO_CHECK_IN,
    WAITING_TO_CONFIRM_REALIZATION;

    public String value() {
        return name();
    }

    public static Realizacija fromValue(String v) {
        return valueOf(v);
    }

}
