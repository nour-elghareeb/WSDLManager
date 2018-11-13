
package net.tedata.webservices.v3.tedatacommontypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.tedata.webservices.v3.tedatacommontypes package. 
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

    private final static QName _MessageHeader_QNAME = new QName("http://webservices.tedata.net/V3/TEDATACommonTypes", "MessageHeader");
    private final static QName _TEDServiceException_QNAME = new QName("http://webservices.tedata.net/V3/TEDATACommonTypes", "TEDServiceException");
    private final static QName _PropertyTypeType_QNAME = new QName("http://webservices.tedata.net/V3/TEDATACommonTypes", "type");
    private final static QName _OperationStatusTypeStatusMessage_QNAME = new QName("http://webservices.tedata.net/V3/TEDATACommonTypes", "statusMessage");
    private final static QName _OperationStatusTypeStatusSubCode_QNAME = new QName("http://webservices.tedata.net/V3/TEDATACommonTypes", "statusSubCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.tedata.webservices.v3.tedatacommontypes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FaultResponseType }
     * 
     */
    public FaultResponseType createFaultResponseType() {
        return new FaultResponseType();
    }

    /**
     * Create an instance of {@link TEDServiceExceptionType }
     * 
     */
    public TEDServiceExceptionType createTEDServiceExceptionType() {
        return new TEDServiceExceptionType();
    }

    /**
     * Create an instance of {@link MessageHeaderType }
     * 
     */
    public MessageHeaderType createMessageHeaderType() {
        return new MessageHeaderType();
    }

    /**
     * Create an instance of {@link OperationStatusType }
     * 
     */
    public OperationStatusType createOperationStatusType() {
        return new OperationStatusType();
    }

    /**
     * Create an instance of {@link ExtensionType }
     * 
     */
    public ExtensionType createExtensionType() {
        return new ExtensionType();
    }

    /**
     * Create an instance of {@link ESBGeneralExceptionType }
     * 
     */
    public ESBGeneralExceptionType createESBGeneralExceptionType() {
        return new ESBGeneralExceptionType();
    }

    /**
     * Create an instance of {@link TEDBaseDataType }
     * 
     */
    public TEDBaseDataType createTEDBaseDataType() {
        return new TEDBaseDataType();
    }

    /**
     * Create an instance of {@link PropertyType }
     * 
     */
    public PropertyType createPropertyType() {
        return new PropertyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageHeaderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.tedata.net/V3/TEDATACommonTypes", name = "MessageHeader")
    public JAXBElement<MessageHeaderType> createMessageHeader(MessageHeaderType value) {
        return new JAXBElement<MessageHeaderType>(_MessageHeader_QNAME, MessageHeaderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TEDServiceExceptionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.tedata.net/V3/TEDATACommonTypes", name = "TEDServiceException")
    public JAXBElement<TEDServiceExceptionType> createTEDServiceException(TEDServiceExceptionType value) {
        return new JAXBElement<TEDServiceExceptionType>(_TEDServiceException_QNAME, TEDServiceExceptionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.tedata.net/V3/TEDATACommonTypes", name = "type", scope = PropertyType.class)
    public JAXBElement<String> createPropertyTypeType(String value) {
        return new JAXBElement<String>(_PropertyTypeType_QNAME, String.class, PropertyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.tedata.net/V3/TEDATACommonTypes", name = "statusMessage", scope = OperationStatusType.class)
    public JAXBElement<String> createOperationStatusTypeStatusMessage(String value) {
        return new JAXBElement<String>(_OperationStatusTypeStatusMessage_QNAME, String.class, OperationStatusType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.tedata.net/V3/TEDATACommonTypes", name = "statusSubCode", scope = OperationStatusType.class)
    public JAXBElement<String> createOperationStatusTypeStatusSubCode(String value) {
        return new JAXBElement<String>(_OperationStatusTypeStatusSubCode_QNAME, String.class, OperationStatusType.class, value);
    }

}
