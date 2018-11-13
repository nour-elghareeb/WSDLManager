
package net.tedata.webservices.fe_getactiondestinationforcustomer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.tedata.webservices.v3.tedatacommontypes.MessageHeaderType;
import net.tedata.webservices.v3.tedatacommontypes.TEDBaseDataType;


/**
 * FE_GetActionDestinationForCustomerType skeleton, TODO: Add more
 * 				response fields here
 * 
 * <p>Java class for FE_getActionDestinationForCustomerResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FE_getActionDestinationForCustomerResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservices.tedata.net/V3/TEDATACommonTypes}TEDBaseDataType">
 *       &lt;sequence>
 *         &lt;element name="MessageHeader" type="{http://webservices.tedata.net/V3/TEDATACommonTypes}MessageHeaderType" minOccurs="0"/>
 *         &lt;element name="MessageBody" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="actionDestination" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "FE_getActionDestinationForCustomerResponseType", propOrder = {
    "messageHeader",
    "messageBody"
})
public class FEGetActionDestinationForCustomerResponseType
    extends TEDBaseDataType
{

    @XmlElement(name = "MessageHeader")
    protected MessageHeaderType messageHeader;
    @XmlElement(name = "MessageBody")
    protected FEGetActionDestinationForCustomerResponseType.MessageBody messageBody;

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
     *     {@link FEGetActionDestinationForCustomerResponseType.MessageBody }
     *     
     */
    public FEGetActionDestinationForCustomerResponseType.MessageBody getMessageBody() {
        return messageBody;
    }

    /**
     * Sets the value of the messageBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEGetActionDestinationForCustomerResponseType.MessageBody }
     *     
     */
    public void setMessageBody(FEGetActionDestinationForCustomerResponseType.MessageBody value) {
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
     *         &lt;element name="actionDestination" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
        "actionDestination"
    })
    public static class MessageBody {

        protected int actionDestination;

        /**
         * Gets the value of the actionDestination property.
         * 
         */
        public int getActionDestination() {
            return actionDestination;
        }

        /**
         * Sets the value of the actionDestination property.
         * 
         */
        public void setActionDestination(int value) {
            this.actionDestination = value;
        }

    }

}
