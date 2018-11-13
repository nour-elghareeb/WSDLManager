
package net.tedata.webservices.v3.tedatacommontypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TEDServiceExceptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TEDServiceExceptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="faultName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="faultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="faultSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="faultMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operationStatus" type="{http://webservices.tedata.net/V3/TEDATACommonTypes}OperationStatusType" minOccurs="0"/>
 *         &lt;element name="extensions" type="{http://webservices.tedata.net/V3/TEDATACommonTypes}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEDServiceExceptionType", propOrder = {
    "faultName",
    "faultCode",
    "faultSource",
    "faultMessage",
    "operationStatus",
    "extensions"
})
public class TEDServiceExceptionType {

    @XmlElement(required = true)
    protected String faultName;
    protected String faultCode;
    protected String faultSource;
    protected String faultMessage;
    protected OperationStatusType operationStatus;
    protected ExtensionType extensions;

    /**
     * Gets the value of the faultName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultName() {
        return faultName;
    }

    /**
     * Sets the value of the faultName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultName(String value) {
        this.faultName = value;
    }

    /**
     * Gets the value of the faultCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultCode() {
        return faultCode;
    }

    /**
     * Sets the value of the faultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultCode(String value) {
        this.faultCode = value;
    }

    /**
     * Gets the value of the faultSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultSource() {
        return faultSource;
    }

    /**
     * Sets the value of the faultSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultSource(String value) {
        this.faultSource = value;
    }

    /**
     * Gets the value of the faultMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultMessage() {
        return faultMessage;
    }

    /**
     * Sets the value of the faultMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultMessage(String value) {
        this.faultMessage = value;
    }

    /**
     * Gets the value of the operationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link OperationStatusType }
     *     
     */
    public OperationStatusType getOperationStatus() {
        return operationStatus;
    }

    /**
     * Sets the value of the operationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationStatusType }
     *     
     */
    public void setOperationStatus(OperationStatusType value) {
        this.operationStatus = value;
    }

    /**
     * Gets the value of the extensions property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public void setExtensions(ExtensionType value) {
        this.extensions = value;
    }

}
