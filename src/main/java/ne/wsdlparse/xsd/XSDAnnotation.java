package ne.wsdlparse.xsd;

import java.io.IOException;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ne.wsdlparse.WSDLManagerRetrieval;
import ne.wsdlparse.exception.WSDLException;

public class XSDAnnotation extends XSDComplexElement {

    public XSDAnnotation(WSDLManagerRetrieval manager, Node node)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        super(manager, node, XSDAnnotation.class);
    }

    @Override
    public String getNodeHelp() {
        return null;
    }

    @Override
    protected Boolean isESQLPrintable() {
        return false;
    }
}