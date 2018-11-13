package net.tedata.webservices.fe_getactiondestinationforcustomer;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SoapAuthHandler implements SOAPHandler<SOAPMessageContext> {
    private String SERVICE_USERNAME = "DP";
    private String SERVICE_PASSWORD = "DP";
    private static final String AUTH_PREFIX = "wsse";
    private static final String AUTH_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
    private int transactiontype = 2;
    static String RETRY_NS = "http://webservices.tedata.net/V1/TEDATACommonTypes";

    private void addAuth(SOAPMessageContext smc) throws Exception {
        SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();

        // Header may or may not exist yet
        SOAPHeader header = envelope.getHeader();
        if (header == null) {
            header = envelope.addHeader();
        }

        // Add WSS Usertoken Element Tree
        final SOAPElement security = header.addChildElement("Security", AUTH_PREFIX, AUTH_NS);
        final SOAPElement userToken = security.addChildElement("UsernameToken", AUTH_PREFIX);
        userToken.addChildElement("Username", AUTH_PREFIX).addTextNode(SERVICE_USERNAME);
        userToken.addChildElement("Password", AUTH_PREFIX).addTextNode(SERVICE_PASSWORD);
        System.err.println("Header ");
    }

    public boolean handleMessage(SOAPMessageContext context) {
        try {
            Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
            if (outboundProperty.booleanValue()) {
                addAuth(context);
            }
            // System.out.println("smc.getMessage() : " +
            // context.getMessage().getSOAPPart().getEnvelope().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    public void close(MessageContext context) {

    }

    public Set<QName> getHeaders() {
        return null;
    }

}