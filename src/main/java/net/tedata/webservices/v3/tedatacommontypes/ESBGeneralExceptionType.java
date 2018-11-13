
package net.tedata.webservices.v3.tedatacommontypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.tedata.webservices.fe_getactiondestinationforcustomer.ESBGeneralException;


/**
 * <p>Java class for ESBGeneralException_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ESBGeneralException_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statusCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Retriable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="GlobalTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESBGeneralException_Type", propOrder = {
    "statusCode",
    "statusMessage",
    "retriable",
    "globalTransactionId"
})
@XmlSeeAlso({
    ESBGeneralException.class
})
public class ESBGeneralExceptionType {

    @XmlElement(required = true)
    protected String statusCode;
    @XmlElement(required = true)
    protected String statusMessage;
    @XmlElement(name = "Retriable")
    protected Boolean retriable;
    @XmlElement(name = "GlobalTransactionId")
    protected String globalTransactionId;

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
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
     * Gets the value of the retriable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRetriable() {
        return retriable;
    }

    /**
     * Sets the value of the retriable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRetriable(Boolean value) {
        this.retriable = value;
    }

    /**
     * Gets the value of the globalTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlobalTransactionId() {
        return globalTransactionId;
    }

    /**
     * Sets the value of the globalTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlobalTransactionId(String value) {
        this.globalTransactionId = value;
    }

}
