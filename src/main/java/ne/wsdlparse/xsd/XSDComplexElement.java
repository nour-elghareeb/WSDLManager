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

public abstract class XSDComplexElement<T> extends XSDElement<T> {

    protected ArrayList<XSDElement<T>> children = new ArrayList<XSDElement<T>>();

    public XSDComplexElement(WSDLManagerRetrieval manager, Node node, Class<?> classType)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        super(manager, node, classType);
        this.loadChildren();
    }

    public ArrayList<XSDElement<T>> getChildren() {
        return this.children;
    }

    public void addChildren(Collection<XSDElement<T>> elements) {
        this.children.addAll(elements);
    }

    public void addChild(XSDElement<T> element) {
        this.children.add(element);
    }

    protected void loadChildren()
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        Node child = Utils.getFirstXMLChild(this.node);
        while (child != null) {
            XSDElement element = XSDElement.getInstance(this.manager, child);
            this.children.add(element);
            child = Utils.getNextXMLSibling(child);
        }
    }

    @Override
    public String toESQL(WSDLManagerRetrieval manager, String xPath) {
        String temp = xPath;
        if (name != null && !xPath.contains(this.name))
            temp += "." + Utils.getParamWithPrefix(this.prefix, this.name);

        ArrayList<ESQLLine> esql = new ArrayList<ESQLLine>();
        for (XSDElement element : this.children) {
            element.toESQL(manager, temp);
        }
        return "";
    }

    @Override
    public String getNodeHelp() {
        return null;
    }
}