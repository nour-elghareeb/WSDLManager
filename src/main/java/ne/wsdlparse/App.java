package ne.wsdlparse;

import ne.wsdlparse.esql.constant.ESQLSource;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            WSDLManager wsdl = new WSDLManager(args[3]);

            for (Service service : wsdl.getServices()) {
                for (Port port : service.getPorts()) {
                    PortType portType = port.getType();
                    for (Operation operation : portType.getOperations()) {
                        System.out.println("Operation: " + operation.getName());
                        System.out.println("Request: ---------------");
                        operation.getRequest().generateESQL();
                        System.out.println(wsdl.getESQLManager().getESQLBlock().generate(ESQLSource.OUTPUT));
                        ;

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
