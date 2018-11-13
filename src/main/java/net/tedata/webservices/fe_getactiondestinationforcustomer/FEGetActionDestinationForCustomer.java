
package net.tedata.webservices.fe_getactiondestinationforcustomer;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 *
 */
@WebServiceClient(name = "FE_GetActionDestinationForCustomer", targetNamespace = "http://webservices.tedata.net/FE_GetActionDestinationForCustomer", wsdlLocation = "file:/tmp/tempdir420014789201613150.tmp/FE_GetActionDestinationForCustomer_1.wsdl")
public class FEGetActionDestinationForCustomer extends Service {

    private final static URL FEGETACTIONDESTINATIONFORCUSTOMER_WSDL_LOCATION;
    private final static WebServiceException FEGETACTIONDESTINATIONFORCUSTOMER_EXCEPTION;
    private final static QName FEGETACTIONDESTINATIONFORCUSTOMER_QNAME = new QName(
            "http://webservices.tedata.net/FE_GetActionDestinationForCustomer", "FE_GetActionDestinationForCustomer");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/home/nour/IBM/IIBT10/test6/Test/FE_GetActionDestinationForCustomer.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FEGETACTIONDESTINATIONFORCUSTOMER_WSDL_LOCATION = url;
        FEGETACTIONDESTINATIONFORCUSTOMER_EXCEPTION = e;
    }

    public FEGetActionDestinationForCustomer() {
        super(__getWsdlLocation(), FEGETACTIONDESTINATIONFORCUSTOMER_QNAME);
    }

    public FEGetActionDestinationForCustomer(WebServiceFeature... features) {
        super(__getWsdlLocation(), FEGETACTIONDESTINATIONFORCUSTOMER_QNAME, features);
    }

    public FEGetActionDestinationForCustomer(URL wsdlLocation) {
        super(wsdlLocation, FEGETACTIONDESTINATIONFORCUSTOMER_QNAME);
    }

    public FEGetActionDestinationForCustomer(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FEGETACTIONDESTINATIONFORCUSTOMER_QNAME, features);
    }

    public FEGetActionDestinationForCustomer(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FEGetActionDestinationForCustomer(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return returns FEGetActionDestinationForCustomerPortType
     */
    @WebEndpoint(name = "FE_GetActionDestinationForCustomerHttpPort")
    public FEGetActionDestinationForCustomerPortType getFEGetActionDestinationForCustomerHttpPort() {
        return super.getPort(new QName("http://webservices.tedata.net/FE_GetActionDestinationForCustomer",
                "FE_GetActionDestinationForCustomerHttpPort"), FEGetActionDestinationForCustomerPortType.class);
    }

    /**
     *
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure
     *                 on the proxy. Supported features not in the
     *                 <code>features</code> parameter will have their default
     *                 values.
     * @return returns FEGetActionDestinationForCustomerPortType
     */
    @WebEndpoint(name = "FE_GetActionDestinationForCustomerHttpPort")
    public FEGetActionDestinationForCustomerPortType getFEGetActionDestinationForCustomerHttpPort(
            WebServiceFeature... features) {
        return super.getPort(
                new QName("http://webservices.tedata.net/FE_GetActionDestinationForCustomer",
                        "FE_GetActionDestinationForCustomerHttpPort"),
                FEGetActionDestinationForCustomerPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FEGETACTIONDESTINATIONFORCUSTOMER_EXCEPTION != null) {
            throw FEGETACTIONDESTINATIONFORCUSTOMER_EXCEPTION;
        }
        return FEGETACTIONDESTINATIONFORCUSTOMER_WSDL_LOCATION;
    }

}
