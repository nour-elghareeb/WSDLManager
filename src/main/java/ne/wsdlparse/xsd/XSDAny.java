package ne.wsdlparse.xsd;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ne.wsdlparse.WSDLManagerRetrieval;
import ne.wsdlparse.exception.WSDLException;

public class XSDAny extends XSDComplexElement<Void> {
    protected boolean isSkippable = true;

    public XSDAny(WSDLManagerRetrieval manager, Node node)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        super(manager, node, XSDAny.class);
    }

    @Override
    public String getNodeHelp() {
        return "You can add any custom element here";
    }

    @Override
    protected Boolean isESQLPrintable() {
        return false;
    }

}