package ne.wsdlparse.xsd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ne.wsdlparse.Utils;
import ne.wsdlparse.WSDLManagerRetrieval;
import ne.wsdlparse.esql.ESQLLine;
import ne.wsdlparse.esql.ESQLRoot;
import ne.wsdlparse.exception.WSDLException;

public class XSDComplexType<T> extends XSDComplexElement<XSDElement<?>> {

    public XSDComplexType(WSDLManagerRetrieval manager, Node node)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        super(manager, node, XSDComplexType.class);
    }

    @Override
    protected Boolean isESQLPrintable() {
        return true;
    }
}