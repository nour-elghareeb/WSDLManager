package ne.wsdlparse.xsd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ne.wsdlparse.Utils;
import ne.wsdlparse.WSDLManagerRetrieval;
import ne.wsdlparse.esql.ESQLLine;
import ne.wsdlparse.esql.ESQLRoot;
import ne.wsdlparse.xsd.constant.XSDSimpleElementType;

public class XSDSimpleElement<T> extends XSDElement<T> {
    private XSDSimpleElementType simpleType;

    public XSDSimpleElement(WSDLManagerRetrieval manager, Node node, XSDSimpleElementType type) {
        super(manager, node, type.getClassType());
        this.simpleType = type;
    }

    @Override
    public String getNodeHelp() {
        return null;
    }

    @Override
    public String toESQL(WSDLManagerRetrieval manager, String xPath) {
        System.out.println(xPath + "." + Utils.getParamWithPrefix(this.prefix, this.name) + " = '';");
        return xPath;
    }

    @Override
    protected Boolean isESQLPrintable() {
        return true;
    }

}