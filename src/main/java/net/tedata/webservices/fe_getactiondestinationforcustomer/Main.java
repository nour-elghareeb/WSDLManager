package net.tedata.webservices.fe_getactiondestinationforcustomer;

import javax.xml.ws.handler.HandlerResolver;

import net.tedata.webservices.v3.tedatacommontypes.MessageHeaderType;

public class Main {
    public static void main(String[] args) {
        testJavaWC();
    }

    public static void testJavaWC() {
        FEGetActionDestinationForCustomer service = new FEGetActionDestinationForCustomer();
        service.setHandlerResolver(new HeaderHandlerResolver());
        FEGetActionDestinationForCustomerPortType portType = service.getFEGetActionDestinationForCustomerHttpPort();
        FEGetActionDestinationForCustomerRequestType feGetActionDestinationForCustomerRequest = new FEGetActionDestinationForCustomerRequestType();

        MessageHeaderType header = new MessageHeaderType();
        header.setChannelID("a");
        feGetActionDestinationForCustomerRequest.setMessageHeader(header);
        FEGetActionDestinationForCustomerRequestType.MessageBody body = new FEGetActionDestinationForCustomerRequestType.MessageBody();
        body.setReferenceSystem(0);
        body.setCustomerNumber("123123");

        feGetActionDestinationForCustomerRequest.setMessageBody(body);
        try {
            FEGetActionDestinationForCustomerResponseType response = portType
                    .feGetActionDestinationForCustomer(feGetActionDestinationForCustomerRequest);
        } catch (ESBGeneralExceptionMessage e) {
            // TODO Auto-generated catch block
            System.out.println("Error code: " + e.getFaultInfo().getStatusCode());
            System.out.println("Error Message: " + e.getMessage());
            System.out.println("Error Message Description : " + e.getFaultInfo().getStatusMessage());
            e.printStackTrace();
        } catch (FEGetActionDestinationForCustomerFaultMsg e) {
            System.out.println("Error code: " + e.getFaultInfo().getStatusCode());
            System.out.println("Error Message: " + e.getMessage());
            System.out.println("Error Message Description : " + e.getFaultInfo().getStatusMessage());
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }
}
