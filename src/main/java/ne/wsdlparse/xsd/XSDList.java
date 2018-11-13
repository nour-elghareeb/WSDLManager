package ne.wsdlparse.xsd;

import org.w3c.dom.Node;

import ne.wsdlparse.Utils;
import ne.wsdlparse.WSDLManagerRetrieval;
import ne.wsdlparse.exception.WSDLException;
import ne.wsdlparse.xsd.constant.XSDSimpleElementType;

public class XSDList extends XSDSimpleElement {
    private XSDSimpleElementType itemType;

    public XSDList(WSDLManagerRetrieval manager, Node node) {
        super(manager, node, XSDSimpleElementType.LIST);
        load();
    }

    @Override
    public String getNodeHelp() {
        return "List value is expected to be values seperated by a space, i.e. item1 item2 item3";
    }

    private void load() {
        try {
            this.itemType = XSDSimpleElementType
                    .parse(Utils.splitPrefixes(Utils.getAttrValueFromNode(this.node, "itemType"))[1]);
        } catch (WSDLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public XSDSimpleElementType getSimpleType() {
        return this.itemType;
    }

}