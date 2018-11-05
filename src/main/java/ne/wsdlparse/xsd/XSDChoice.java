package ne.wsdlparse.xsd;

import java.io.IOException;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ne.wsdlparse.WSDLManagerRetrieval;
import ne.wsdlparse.exception.WSDLException;

public class XSDChoice extends XSDComplexElement<XSDElement<?>> {
    public XSDChoice(WSDLManagerRetrieval manager, Node node)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        super(manager, node, XSDChoice.class);
    }

    @Override
    public String getNodeHelp() {
        return String.format(Locale.getDefault(), "Only one of the following %s parameters is allowed.",
                this.children.size());
    }

    @Override
    protected Boolean isESQLPrintable() {
        return true;
    }
}