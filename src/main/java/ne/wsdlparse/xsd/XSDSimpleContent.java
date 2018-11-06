package ne.wsdlparse.xsd;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ne.wsdlparse.WSDLManagerRetrieval;
import ne.wsdlparse.exception.WSDLException;

public class XSDSimpleContent extends XSDComplexElement<XSDElement<?>> {
    public XSDSimpleContent(WSDLManagerRetrieval manager, Node node)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        super(manager, node, XSDComplexType.class);
    }

    @Override
    protected Boolean isESQLPrintable() {
        return true;
    }
}