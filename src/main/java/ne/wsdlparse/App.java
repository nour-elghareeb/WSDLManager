package ne.wsdlparse;

import ne.wsdlparse.esql.constant.ESQLSource;
import ne.wsdlparse.utility.ConsoleStyle;

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
                        operation.getFault()[0].generateESQL();
                        // operation.getFault()[1].generateESQL();

                        // operation.getResponse().generateESQL();
                        // operation.getFault().generateESQL();

                        ;
                        //
                        break;
                    }
                    break;
                }
            }
            wsdl.getESQLManager().getESQLBlock().print(ESQLSource.OUTPUT);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
