
package net.tedata.webservices.v3.tedatacommontypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaultResponse_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaultResponse_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statusCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="statusMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="backEnd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultResponse_Type", propOrder = {
    "statusCode",
    "statusMessage",
    "backEnd"
})
public class FaultResponseType {

    protected int statusCode;
    @XmlElement(required = true)
    protected String statusMessage;
    protected String backEnd;

    /**
     * Gets the value of the statusCode property.
     * 
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     */
    public void setStatusCode(int value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the statusMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * Sets the value of the statusMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusMessage(String value) {
        this.statusMessage = value;
    }

    /**
     * Gets the value of the backEnd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackEnd() {
        return backEnd;
    }

    /**
     * Sets the value of the backEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackEnd(String value) {
        this.backEnd = value;
    }

}
