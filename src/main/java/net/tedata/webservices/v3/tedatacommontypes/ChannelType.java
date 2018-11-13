
package net.tedata.webservices.v3.tedatacommontypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Channel_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Channel_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Matrix"/>
 *     &lt;enumeration value="CCP"/>
 *     &lt;enumeration value="OMS"/>
 *     &lt;enumeration value="SSP"/>
 *     &lt;enumeration value="SIMBA"/>
 *     &lt;enumeration value="PCRF"/>
 *     &lt;enumeration value="AAA"/>
 *     &lt;enumeration value="DP"/>
 *     &lt;enumeration value="RSP"/>
 *     &lt;enumeration value="BEE"/>
 *     &lt;enumeration value="PETRO-TRADE"/>
 *     &lt;enumeration value="HomeCollection"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Channel_Type")
@XmlEnum
public enum ChannelType {

    @XmlEnumValue("Matrix")
    MATRIX("Matrix"),
    CCP("CCP"),
    OMS("OMS"),
    SSP("SSP"),
    SIMBA("SIMBA"),
    PCRF("PCRF"),
    AAA("AAA"),
    DP("DP"),
    RSP("RSP"),
    BEE("BEE"),
    @XmlEnumValue("PETRO-TRADE")
    PETRO_TRADE("PETRO-TRADE"),
    @XmlEnumValue("HomeCollection")
    HOME_COLLECTION("HomeCollection");
    private final String value;

    ChannelType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ChannelType fromValue(String v) {
        for (ChannelType c: ChannelType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
