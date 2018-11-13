
package net.tedata.webservices.fe_getactiondestinationforcustomer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.tedata.webservices.v3.tedatacommontypes.MessageHeaderType;
import net.tedata.webservices.v3.tedatacommontypes.TEDBaseDataType;


/**
 * FE_GetActionDestinationForCustomerType skeleton, TODO: Add
 *   				more request fields here
 * 
 * <p>Java class for FE_getActionDestinationForCustomerRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FE_getActionDestinationForCustomerRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservices.tedata.net/V3/TEDATACommonTypes}TEDBaseDataType">
 *       &lt;sequence>
 *         &lt;element name="MessageHeader" type="{http://webservices.tedata.net/V3/TEDATACommonTypes}MessageHeaderType"/>
 *         &lt;element name="MessageBody">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="referenceSystem" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;choice>
 *                     &lt;element name="customerNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                     &lt;element name="phoneInfo" type="{http://webservices.tedata.net/FE_GetActionDestinationForCustomer}FE_phoneNumber_Type"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FE_getActionDestinationForCustomerRequestType", propOrder = {
    "messageHeader",
    "messageBody"
})
public class FEGetActionDestinationForCustomerRequestType
    extends TEDBaseDataType
{

    @XmlElement(name = "MessageHeader", required = true)
    protected MessageHeaderType messageHeader;
    @XmlElement(name = "MessageBody", required = true)
    protected FEGetActionDestinationForCustomerRequestType.MessageBody messageBody;

    /**
     * Gets the value of the messageHeader property.
     * 
     * @return
     *     possible object is
     *     {@link MessageHeaderType }
     *     
     */
    public MessageHeaderType getMessageHeader() {
        return messageHeader;
    }

    /**
     * Sets the value of the messageHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageHeaderType }
     *     
     */
    public void setMessageHeader(MessageHeaderType value) {
        this.messageHeader = value;
    }

    /**
     * Gets the value of the messageBody property.
     * 
     * @return
     *     possible object is
     *     {@link FEGetActionDestinationForCustomerRequestType.MessageBody }
     *     
     */
    public FEGetActionDestinationForCustomerRequestType.MessageBody getMessageBody() {
        return messageBody;
    }

    /**
     * Sets the value of the messageBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEGetActionDestinationForCustomerRequestType.MessageBody }
     *     
     */
    public void setMessageBody(FEGetActionDestinationForCustomerRequestType.MessageBody value) {
        this.messageBody = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="referenceSystem" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;choice>
     *           &lt;element name="customerNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *           &lt;element name="phoneInfo" type="{http://webservices.tedata.net/FE_GetActionDestinationForCustomer}FE_phoneNumber_Type"/>
     *         &lt;/choice>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "referenceSystem",
        "customerNumber",
        "phoneInfo"
    })
    public static class MessageBody {

        protected int referenceSystem;
        protected String customerNumber;
        protected FEPhoneNumberType phoneInfo;

        /**
         * Gets the value of the referenceSystem property.
         * 
         */
        public int getReferenceSystem() {
            return referenceSystem;
        }

        /**
         * Sets the value of the referenceSystem property.
         * 
         */
        public void setReferenceSystem(int value) {
            this.referenceSystem = value;
        }

        /**
         * Gets the value of the customerNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCustomerNumber() {
            return customerNumber;
        }

        /**
         * Sets the value of the customerNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCustomerNumber(String value) {
            this.customerNumber = value;
        }

        /**
         * Gets the value of the phoneInfo property.
         * 
         * @return
         *     possible object is
         *     {@link FEPhoneNumberType }
         *     
         */
        public FEPhoneNumberType getPhoneInfo() {
            return phoneInfo;
        }

        /**
         * Sets the value of the phoneInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link FEPhoneNumberType }
         *     
         */
        public void setPhoneInfo(FEPhoneNumberType value) {
            this.phoneInfo = value;
        }

    }

}
