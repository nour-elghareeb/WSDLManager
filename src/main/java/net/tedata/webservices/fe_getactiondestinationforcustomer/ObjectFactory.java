
package net.tedata.webservices.fe_getactiondestinationforcustomer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import net.tedata.webservices.v3.tedatacommontypes.FaultResponseType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.tedata.webservices.fe_getactiondestinationforcustomer package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FEGetActionDestinationForCustomerResponse_QNAME = new QName("http://webservices.tedata.net/FE_GetActionDestinationForCustomer", "FE_getActionDestinationForCustomerResponse");
    private final static QName _FEGetActionDestinationForCustomerRequest_QNAME = new QName("http://webservices.tedata.net/FE_GetActionDestinationForCustomer", "FE_getActionDestinationForCustomerRequest");
    private final static QName _FEGetActionDestinationForCustomerFault_QNAME = new QName("http://webservices.tedata.net/FE_GetActionDestinationForCustomer", "FE_getActionDestinationForCustomerFault");
    private final static QName _ESBGeneralException_QNAME = new QName("http://webservices.tedata.net/FE_GetActionDestinationForCustomer", "ESBGeneralException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.tedata.webservices.fe_getactiondestinationforcustomer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FEGetActionDestinationForCustomerResponseType }
     * 
     */
    public FEGetActionDestinationForCustomerResponseType createFEGetActionDestinationForCustomerResponseType() {
        return new FEGetActionDestinationForCustomerResponseType();
    }

    /**
     * Create an instance of {@link FEGetActionDestinationForCustomerRequestType }
     * 
     */
    public FEGetActionDestinationForCustomerRequestType createFEGetActionDestinationForCustomerRequestType() {
        return new FEGetActionDestinationForCustomerRequestType();
    }

    /**
     * Create an instance of {@link ESBGeneralException }
     * 
     */
    public ESBGeneralException createESBGeneralException() {
        return new ESBGeneralException();
    }

    /**
     * Create an instance of {@link FEPhoneNumberType }
     * 
     */
    public FEPhoneNumberType createFEPhoneNumberType() {
        return new FEPhoneNumberType();
    }

    /**
     * Create an instance of {@link FEGetActionDestinationForCustomerResponseType.MessageBody }
     * 
     */
    public FEGetActionDestinationForCustomerResponseType.MessageBody createFEGetActionDestinationForCustomerResponseTypeMessageBody() {
        return new FEGetActionDestinationForCustomerResponseType.MessageBody();
    }

    /**
     * Create an instance of {@link FEGetActionDestinationForCustomerRequestType.MessageBody }
     * 
     */
    public FEGetActionDestinationForCustomerRequestType.MessageBody createFEGetActionDestinationForCustomerRequestTypeMessageBody() {
        return new FEGetActionDestinationForCustomerRequestType.MessageBody();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FEGetActionDestinationForCustomerResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.tedata.net/FE_GetActionDestinationForCustomer", name = "FE_getActionDestinationForCustomerResponse")
    public JAXBElement<FEGetActionDestinationForCustomerResponseType> createFEGetActionDestinationForCustomerResponse(FEGetActionDestinationForCustomerResponseType value) {
        return new JAXBElement<FEGetActionDestinationForCustomerResponseType>(_FEGetActionDestinationForCustomerResponse_QNAME, FEGetActionDestinationForCustomerResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FEGetActionDestinationForCustomerRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.tedata.net/FE_GetActionDestinationForCustomer", name = "FE_getActionDestinationForCustomerRequest")
    public JAXBElement<FEGetActionDestinationForCustomerRequestType> createFEGetActionDestinationForCustomerRequest(FEGetActionDestinationForCustomerRequestType value) {
        return new JAXBElement<FEGetActionDestinationForCustomerRequestType>(_FEGetActionDestinationForCustomerRequest_QNAME, FEGetActionDestinationForCustomerRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.tedata.net/FE_GetActionDestinationForCustomer", name = "FE_getActionDestinationForCustomerFault")
    public JAXBElement<FaultResponseType> createFEGetActionDestinationForCustomerFault(FaultResponseType value) {
        return new JAXBElement<FaultResponseType>(_FEGetActionDestinationForCustomerFault_QNAME, FaultResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGeneralException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.tedata.net/FE_GetActionDestinationForCustomer", name = "ESBGeneralException")
    public JAXBElement<ESBGeneralException> createESBGeneralException(ESBGeneralException value) {
        return new JAXBElement<ESBGeneralException>(_ESBGeneralException_QNAME, ESBGeneralException.class, null, value);
    }

}
