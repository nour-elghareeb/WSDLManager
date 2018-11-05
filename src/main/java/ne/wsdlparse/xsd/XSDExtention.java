package ne.wsdlparse.xsd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ne.wsdlparse.Utils;
import ne.wsdlparse.WSDLManagerRetrieval;
import ne.wsdlparse.exception.WSDLException;

public class XSDExtention extends XSDComplexElement<XSDElement<?>> {
    private String base;

    public XSDExtention(WSDLManagerRetrieval manager, Node node)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        super(manager, node, XSDExtention.class);

    }

    @Override
    public String getNodeHelp() {
        return null;
    }

    /**
     * @param base the base to set
     */
    public void setBase(String base) {
        this.base = Utils.splitPrefixes(base)[1];
    }

    @Override
    protected void loadChildren()
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        this.setBase(Utils.getAttrValueFromNode(node, "base"));
        Node base = (Node) this.manager.getXSDManager()
                .find(String.format(Locale.getDefault(), "/schema/*[@name='%s']", this.base), XPathConstants.NODE);
        XSDComplexElement baseElement = (XSDComplexElement) ((XSDComplexElement) XSDElement.getInstance(this.manager,
                base)).getChildren().get(0);
        super.loadChildren();
        XSDComplexElement baseChild = (XSDComplexElement) getChildren().get(0);

        for (XSDElement el : (ArrayList<XSDComplexElement>) baseChild.getChildren()) {
            baseElement.addChild(el);
        }
        this.children = new ArrayList<XSDElement<XSDElement<?>>>();
        this.children.add(baseElement);
    }

    @Override
    protected Boolean isESQLPrintable() {
        return true;
    }
}