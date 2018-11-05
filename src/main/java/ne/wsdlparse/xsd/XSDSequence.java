package ne.wsdlparse.xsd;

import java.io.IOException;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ne.wsdlparse.WSDLManagerRetrieval;
import ne.wsdlparse.exception.WSDLException;

public class XSDSequence extends XSDComplexElement {
    public XSDSequence(WSDLManagerRetrieval manager, Node node)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        super(manager, node, XSDSequence.class);
    }

    @Override
    public String getNodeHelp() {
        return String.format(Locale.getDefault(),
                "The following % children must appear in a sequence (in order). Each element can occurr from 0 to any number of times",
                this.children.size());
    }

    @Override
    protected Boolean isESQLPrintable() {
        return true;
    }

}