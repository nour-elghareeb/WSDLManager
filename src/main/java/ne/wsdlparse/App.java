package ne.wsdlparse;

import javax.xml.xpath.XPathConstants;

import org.w3c.dom.Node;

import ne.wsdlparse.esql.ESQLRoot;
import ne.wsdlparse.xsd.XSDManager;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            WSDLManager wsdl = new WSDLManager(args[0]);
            // XSDManager manager = wsdl.getXSDManager();
            // Node node = (Node)
            // manager.find("//complexType[@name='FE_getActionDestinationForCustomerRequestType']",
            // XPathConstants.NODE);

            for (Service service : wsdl.getServices()) {
                for (Port port : service.getPorts()) {
                    PortType portType = port.getType();
                    for (Operation operation : portType.getOperations()) {
                        System.out.println("Operation: " + operation.getName());
                        System.out.println("Request: ---------------");
                        System.out.println(operation.getFault().generateESQL().generate(ESQLRoot.OUTPUT));

                        // System.out.println("Response: ---------------");
                        // System.out.println(operation.getResponse().generateESQL().generate(ESQLRoot.OUTPUT));
                        // System.out.println("------------------------------------------------------");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
