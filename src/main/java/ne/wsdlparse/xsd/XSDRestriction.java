package ne.wsdlparse.xsd;

import java.io.IOException;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ne.wsdlparse.Utils;
import ne.wsdlparse.WSDLManagerRetrieval;
import ne.wsdlparse.exception.WSDLException;
import ne.wsdlparse.xsd.constant.XSDSimpleElementType;

public class XSDRestriction extends XSDComplexElement<XSDElement> {
    private enum XSDRestrictionChild {
        enumeration, fractionDigits, length, maxExclusive, maxInclusive, maxLength, minExclusive, minInclusive,
        minLength, pattern, totalDigits, whiteSpace
    }

    private String base;

    public XSDRestriction(WSDLManagerRetrieval manager, Node node)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        super(manager, node, XSDExtention.class);
    }

    @Override
    public String getNodeHelp() {
        return null;
    }

    // TODO: fetch base and load children...
    @Override
    protected void loadChildren()
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
        this.setBase(Utils.getAttrValueFromNode(node, "base"));
        try {
            XSDSimpleElementType simpleType = XSDSimpleElementType.parse(this.base);
        } catch (WSDLException e) {

        }
        // Node base = (Node) this.manager.getXSDManager()
        // .find(String.format(Locale.getDefault(), "/schema/*[@name='%s']", this.base),
        // XPathConstants.NODE);
    }

    private void setBase(String base) {
        this.base = Utils.splitPrefixes("base")[1];
    }

    @Override
    protected Boolean isESQLPrintable() {
        return true;
    }
}