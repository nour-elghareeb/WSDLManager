package ne.wsdlparse.xsd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ne.wsdlparse.Utils;
import ne.wsdlparse.WSDLManagerRetrieval;
import ne.wsdlparse.esql.ESQLLine;
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
    public void toESQL() {
        this.manager.getESQLManager().addParam(this.prefix, this.name, this.simpleType);
    }

    @Override
    protected Boolean isESQLPrintable() {
        return true;
    }

}