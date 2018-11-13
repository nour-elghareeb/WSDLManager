package ne.wsdlparse.xsd;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ne.wsdlparse.WSDLManagerRetrieval;
import ne.wsdlparse.exception.WSDLException;
import ne.wsdlparse.xsd.constant.XSDSimpleElementType;

public class XSDComplexType<T> extends XSDComplexElement<XSDElement<?>> {

    private XSDSimpleElementType simpleType;
    private boolean hasList;

    public XSDComplexType(WSDLManagerRetrieval manager, Node node)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        super(manager, node, XSDComplexType.class);
    }

    @Override
    protected Boolean isESQLPrintable() {
        return true;
    }

    @Override
    protected boolean validateChild(Node child, XSDElement element)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        // return super.validateChild(child, element);
        if (element instanceof XSDSimpleContent) {
            this.simpleType = ((XSDSimpleContent) element).getSimpleType();
            this.hasRestriction = ((XSDSimpleContent) element).hasRestriction();
            return this.hasRestriction;
        } else if (element instanceof XSDSimpleType) {
            this.simpleType = ((XSDSimpleType) element).getSimpleType();
            this.hasRestriction = ((XSDSimpleType) element).hasRestriction();
            this.hasList = ((XSDSimpleType) element).hasList();
            return this.hasRestriction || this.hasList;
        }
        return true;
    }

    @Override
    public void toESQL() {
        if (this.simpleType == null) {
            super.toESQL();
            return;
        }
        if (this.hasRestriction || this.hasList)
            super.toESQL();
        this.manager.getESQLManager().addParam(this.prefix, this.name, this.simpleType);
    }
}