package ne.wsdlparse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ne.wsdlparse.esql.ESQLBlock;
import ne.wsdlparse.esql.ESQLLine;
import ne.wsdlparse.esql.ESQLRoot;
import ne.wsdlparse.exception.WSDLException;
import ne.wsdlparse.exception.WSDLExceptionCode;
import ne.wsdlparse.xsd.XSDElement;

public class WSDLMessage {
    private String name;
    private boolean isExternal;
    private WSDLManagerRetrieval manager;
    private String prefix;
    public ArrayList<XSDElement> parts = new ArrayList<XSDElement>();
    private Node node;
    private Operation operation;
    private WSDLProperty encodingStyle;

    public WSDLMessage(WSDLManagerRetrieval manager, Operation operation, Node node)
            throws XPathExpressionException, WSDLException, SAXException, IOException, ParserConfigurationException {
        this.manager = manager;
        this.node = node;
        this.operation = operation;
        if (node != null) {
            // this.setName(Utils.getAttrValueFromNode(node, "name"));
            this.loadParams();
        }
    }

    public WSDLMessage(WSDLManagerRetrieval manager2, Operation operation2) {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     * @throws XPathExpressionException
     */
    public void setName(String name) throws XPathExpressionException {
        if (name == null)
            return;
        String[] temp = Utils.splitPrefixes(name);
        this.prefix = temp[0];
        this.name = temp[1];

        // if (this.isExternal) {
        // this.loadExternalPart();
        // } else {
        // this.loadInternalPart();
        // }
    }

    public String getNameWithPrefix() {
        StringBuilder builder = new StringBuilder();
        if (this.prefix != null) {
            builder.append(this.prefix);
            builder.append(":");
        }
        builder.append(this.name);
        return builder.toString();
    }

    public ESQLBlock generateESQL() {

        String xPath = Utils.getParamWithPrefix(this.prefix, this.name);
        ArrayList<ESQLLine> esql = new ArrayList<ESQLLine>();
        for (XSDElement element : this.parts) {
            element.toESQL(manager, xPath);
        }
        return new ESQLBlock(this.manager, esql);

    }

    private void loadDocumentParams()
            throws XPathExpressionException, WSDLException, SAXException, IOException, ParserConfigurationException {
        // Check if literal or wrappd..
        NodeList parts = (NodeList) this.manager.getXPath().compile("part").evaluate(this.node, XPathConstants.NODESET);
        if (parts.getLength() == 1)
            this.loadDocumentWrappedPart(parts.item(0));
        else if (parts.getLength() > 1) {
            this.loadDocumentParts(parts);
        } else
            throw new WSDLException(WSDLExceptionCode.EMPTY_MESSAGE_PARAMS);
    }

    private void loadDocumentWrappedPart(Node wrappedPart)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        setName(Utils.getAttrValueFromNode(wrappedPart, "element"));
        // Node element = (Node) this.manager.getXPath().compile()
        Node element = (Node) this.manager.getXSDManager().find(
                String.format(Locale.getDefault(), "/schema/element[@name='%s']", this.name), XPathConstants.NODE);

        this.loadElement(element);
    }

    private void loadDocumentParts(NodeList parts) {

    }

    private void loadRPCParams() {

    }

    public void loadParams()
            throws WSDLException, XPathExpressionException, SAXException, IOException, ParserConfigurationException {

        // Check if operation is RPC or Document and then calls the appropriate method
        switch (this.operation.getStyle()) {
        case DOCUMENT:
            this.loadDocumentParams();
            break;
        case RPC:
            this.loadRPCParams();
        default:
            throw new WSDLException(WSDLExceptionCode.INVALID_OPERATION_STYLE);
        }

        // NodeList msgParamsNodes = (NodeList)
        // this.manager.getXPath().compile(String.format(Locale.getDefault(), "part"))
        // .evaluate(this.node, XPathConstants.NODESET);
        // // Loop over parts in curent message
        // for (int i = 0; i < msgParamsNodes.getLength(); i++) {
        // // get part node
        // Node partNode = msgParamsNodes.item(i);
        // // checking if the part DOES refer to another element by checking attr (type)
        // // type exists, no refer here, load part directly
        // if (Utils.getAttrValueFromNode(partNode, "type") != null) {
        // loadPartWithType(partNode);
        // }
        // // Okay, it refers to another element, let's search the inline schema
        // else {
        // loadPartWithElement(partNode);
        // }

        // }
    }

    private void loadExternalPart() {

    }

    private void loadElement(Node element)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {

        this.parts.add(XSDElement.getInstance(this.manager, element));
        // // Split element name from prfix
        // String[] elementName =
        // Utils.splitPrefixes(Utils.getAttrValueFromNode(element, "element"));
        // // fetch element from inline schema
        // String xpath = String.format(Locale.getDefault(),
        // "/definitions/types/schema[@targetNamespace='%s']",
        // this.manager.getTargetNameSpace());
        // Node schema = (Node)
        // this.manager.getXPath().compile(xpath).evaluate(this.manager.getWSDLFile(),
        // XPathConstants.NODE);
        // // No schema found, wsdl has errors?!!
        // if (schema == null) {
        // return;
        // }

        // // TODO: uncomment this block
        // // xpath = String.format(Locale.getDefault(), "element[@name='%s']",
        // // elementName[1]);
        // // // check for inline schema
        // Node element = (Node) this.manager.getXPath().compile(xpath).evaluate(schema,
        // XPathConstants.NODE);
        // if (element != null) {
        // check if element refer to another type
        // String type = Utils.getAttrValueFromNode(element, "type");
        // // type not found, check children..
        // if (type == null) {
        // element = Utils.getFirstXMLChild(element);
        // } else {
        // element = (Node) this.manager.getXSDManager().find(
        // String.format(Locale.getDefault(), "/schema/*[@name='%s']",
        // Utils.splitPrefixes(type)[1]),
        // XPathConstants.NODE);
        // }
        // XSDElement part = XSDElement.getInstance(this.manager, element);
        // if (part != null) {
        // // part.setName(Utils.getAttrValueFromNode(element, "element"));

        // }

        // check for include....
        // String xpath = String.format(Locale.getDefault(),
        // "/definitions/types/schema[@targetNamespace='%s']/element[@name='%s']",
        // this.manager.getTargetNameSpace(), elementName[1]);
        // Node elementNode = (Node)
        // this.manager.getXPath().compile(xpath).evaluate(this.manager.getWSDLFile(),
        // XPathConstants.NODE);
        // // Not found in the inline schema.. let's check if is there include (external
        // // xsd)
        // String az =
        String xx = this.manager.getXPath().getNamespaceContext().getNamespaceURI("s");
        // String ts = this.manager.getTargetNameSpace();
    }

    /**
     * *
     *
     * @param node Part xml node in message
     * @throws XPathExpressionException
     * @throws WSDLException
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    private void loadPartWithType(Node node)
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, WSDLException {
        // XSDElement element;
        // String type = Utils.getAttrValueFromNode(node, "type");
        // // String name = ;
        // // String defaultValue = Utils.getAttrValueFromNode(node, "defaultValue");
        // type = type.replace("xsd:", "");
        // if (type.equals("string"))
        // element = new XSDString();
        // else if (type.equals("integer"))
        // element = new XSDInteger();
        // else if (type.equals("boolean"))
        // element = new XSDBoolean();
        // else if (type.equals("choice"))
        // element = new XSDChoice();
        // else
        // return;
        // element.setName(Utils.getAttrValueFromNode(node, "name"));
        // element.setMaxOccurs(Utils.getAttrValueFromNode(node, "maxOccurs"));
        // element.setMinOccurs(Utils.getAttrValueFromNode(node, "minOccurs"));
        // element.setNillable(Utils.getAttrValueFromNode(node, "nillable"));
        // element.setDefaultValue(Utils.getAttrValueFromNode(node, "default"));
        this.parts.add(XSDElement.getInstance(this.manager, node));
        // final NodeList partNodes = (NodeList) this.manager.getXPath()
        // .compile(String.format(Locale.getDefault(), "part[@name='%s']", partName))
        // .evaluate(this.node, XPathConstants.NODESET);

        // this.elements = new ArrayList<XSDElement>() {
        // {
        // for (int i = 0; i < partNodes.getLength(); i++) {
        // XSDElement element;
        // Node node = partNodes.item(i);
        // String type = Utils.getAttrValueFromNode(node, "type");
        // // String name = ;
        // // String defaultValue = Utils.getAttrValueFromNode(node, "defaultValue");
        // type = type.replace("xsd:", "");
        // if (type.equals("string"))
        // element = new XSDString();
        // else if (type.equals("integer"))
        // element = new XSDInteger();
        // else if (type.equals("boolean"))
        // element = new XSDBoolean();
        // else if (type.equals("choice"))
        // element = new XSDChoice();
        // else
        // break;
        // element.setName(Utils.getAttrValueFromNode(node, "name"));
        // element.setMaxOccurs(Utils.getAttrValueFromNode(node, "maxOccurs"));
        // element.setMinOccurs(Utils.getAttrValueFromNode(node, "minOccurs"));
        // element.setNillable(Utils.getAttrValueFromNode(node, "nillable"));
        // element.setDefaultValue(Utils.getAttrValueFromNode(node, "default"));
        // add(element);
        // String xx = "aa";
        // }
        // }
        // };

    }

    public void setIsExternal(boolean isExternal) {
        this.isExternal = isExternal;
    }

    /**
     * @return boolean return the isExternal
     */
    public boolean isIsExternal() {
        return isExternal;
    }

    /**
     * @return WSDLManagerRetrieval return the manager
     */
    public WSDLManagerRetrieval getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(WSDLManagerRetrieval manager) {
        this.manager = manager;
    }

    /**
     * @return String return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param prefix the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * @param node the node to set
     */
    public void setNode(Node node) {
        this.node = node;
    }

    /**
     * @return Operation return the operation
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setEncodingStyle(String value) {
        if (value == null)
            return;
        if (value.toLowerCase().trim().equals("encoded"))
            this.encodingStyle = WSDLProperty.ENCODED;
        else if (value.toLowerCase().trim().equals("literal"))
            this.encodingStyle = WSDLProperty.LITERAL;
    }

}
