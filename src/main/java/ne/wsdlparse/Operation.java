package ne.wsdlparse;

import java.io.IOException;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ne.wsdlparse.exception.WSDLException;

public class Operation {

    private String name;
    private WSDLMessage request;
    private WSDLMessage response;
    private WSDLMessage fault;
    private WSDLManagerRetrieval manager;
    private Node node;
    private PortType portType;
    private WSDLProperty style;
    private String soapAction;

    public Operation(WSDLManagerRetrieval manager, PortType portType, Node node)
            throws XPathExpressionException, WSDLException, SAXException, IOException, ParserConfigurationException {

        this.manager = manager;
        this.node = node;
        setPortType(portType);
        this.setName(Utils.getAttrValueFromNode(node, "name"));
        this.loadOperationDetails();
        this.loadParams();
    }

    private void loadParams() throws XPathExpressionException, WSDLException, SAXException, IOException, ParserConfigurationException {

        this.request = this.loadParamNode("input", request);
        this.response = this.loadParamNode("output", response);
        this.fault = this.loadParamNode("fault", fault);
    }

    private void loadOperationDetails()
            throws XPathExpressionException, WSDLException, SAXException, IOException, ParserConfigurationException {
        this.request = new WSDLMessage(this.manager, this, null);
        this.response = new WSDLMessage(this.manager, this, null);
        this.fault = new WSDLMessage(this.manager, this, null);
        Node operation = (Node) this.manager.getXPath()
                .compile(String.format(Locale.getDefault(), "operation[@name='%s']", this.name))
                .evaluate(this.portType.getPort().getBinding().getNode(), XPathConstants.NODE);

        Node soap = (Node) this.manager.getXPath().compile(String.format(Locale.getDefault(), "operation"))
                .evaluate(operation, XPathConstants.NODE);

        this.setStyle(Utils.getAttrValueFromNode(soap, "style"));
        this.setSoapAction(Utils.getAttrValueFromNode(soap, "soapAction"));
        Node input = (Node) this.manager.getXPath().compile(String.format(Locale.getDefault(), "input/body"))
                .evaluate(operation, XPathConstants.NODE);
        Node output = (Node) this.manager.getXPath().compile(String.format(Locale.getDefault(), "output/body"))
                .evaluate(operation, XPathConstants.NODE);
        Node fault = (Node) this.manager.getXPath().compile(String.format(Locale.getDefault(), "fault/fault"))
                .evaluate(operation, XPathConstants.NODE);

        this.request.setEncodingStyle(Utils.getAttrValueFromNode(input, "use"));
        this.response.setEncodingStyle(Utils.getAttrValueFromNode(output, "use"));
        this.fault.setEncodingStyle(Utils.getAttrValueFromNode(fault, "use"));
    }

    private void setStyle(String value) {
        if (value == null)
            this.style = this.getPortType().getPort().getBinding().getGlobalStyle();
        else if (value.toLowerCase().trim().equals("document"))
            this.style = WSDLProperty.DOCUMENT;
        else if (value.toLowerCase().trim().equals("rpc"))
            this.style = WSDLProperty.RPC;
        else
            this.style = this.getPortType().getPort().getBinding().getGlobalStyle();
    }

    /**
     * @return WSDLProperty return the style
     */
    public WSDLProperty getStyle() {
        return this.style;
    }

    private WSDLMessage loadParamNode(String paramName, WSDLMessage message)
            throws XPathExpressionException, WSDLException, SAXException, IOException, ParserConfigurationException {
        // Loading param message either [input], [output], [fault]
        Node paramNode = (Node) this.manager.getXPath().compile(String.format(Locale.getDefault(), "%s", paramName))
                .evaluate(this.node, XPathConstants.NODE);
        if (paramNode == null) {
            return null;
        }
        // get message name...
        String paramMsgName[] = Utils.splitPrefixes(Utils.getAttrValueFromNode(paramNode, "message"));
        // get message node
        Node messageNode = (Node) this.manager.getXPath()
                .compile(String.format(Locale.getDefault(), "/definitions/message[@name='%s']", paramMsgName[1]))
                .evaluate(this.manager.getWSDLFile(), XPathConstants.NODE);
        if (messageNode == null)
            return null;

        message.setNode(messageNode);
        message.setName(Utils.getAttrValueFromNode(paramNode, "message"));
        message.loadParams();

        return message;
    }

    /**
     * @return the fault
     */
    public WSDLMessage getFault() {
        return fault;
    }

    /**
     * @param fault the fault to set
     */
    public void setFault(WSDLMessage fault) {
        this.fault = fault;
    }

    /**
     * @return the response
     */
    public WSDLMessage getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(WSDLMessage response) {
        this.response = response;
    }

    /**
     * @return the request
     */
    public WSDLMessage getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(WSDLMessage request) {
        this.request = request;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPortType(PortType portType) throws XPathExpressionException {
        this.portType = portType;
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
     * @param node the node to set
     */
    public void setNode(Node node) {
        this.node = node;
    }

    /**
     * @return PortType return the portType
     */
    public PortType getPortType() {
        return portType;
    }

    /**
     * @return String return the soapAction
     */
    public String getSoapAction() {
        return soapAction;
    }

    /**
     * @param soapAction the soapAction to set
     */
    public void setSoapAction(String soapAction) {
        this.soapAction = soapAction;
    }

}