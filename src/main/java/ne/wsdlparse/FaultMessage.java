package ne.wsdlparse;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ne.wsdlparse.exception.WSDLException;
import ne.wsdlparse.xsd.XSDElement;
import ne.wsdlparse.xsd.constant.XSDSimpleElementType;

public class FaultMessage extends WSDLMessage {
    public FaultMessage(WSDLManagerRetrieval manager, Operation operation, Node node)
            throws XPathExpressionException, WSDLException, SAXException, IOException, ParserConfigurationException {
        super(manager, operation, node);
    }

    @Override
    public void generateESQL() {
        this.manager.getESQLManager().clearTree();
        this.manager.getESQLManager().levelUp("soapenv", "Fault");
        this.manager.getESQLManager().addParam(null, "faultcode", XSDSimpleElementType.STRING);
        this.manager.getESQLManager().addParam(null, "faultstring   ", XSDSimpleElementType.STRING);
        this.manager.getESQLManager().addParam(null, "faultactor   ", XSDSimpleElementType.STRING);
        this.manager.getESQLManager().levelUp(null, "detail");
        this.manager.getESQLManager().levelUp(this.prefix, this.name);
        for (XSDElement element : this.parts) {
            element.toESQL();
        }
        this.manager.getESQLManager().levelDown(this.name, this.prefix);
        this.manager.getESQLManager().levelDown(null, "detail");
        this.manager.getESQLManager().levelDown("soapenv", "Fault");
    }
}