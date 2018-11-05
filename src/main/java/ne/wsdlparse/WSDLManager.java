package ne.wsdlparse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ClassNotFoundException;
import java.io.IOException;

import org.xml.sax.SAXException;

import ne.wsdlparse.xsd.XSDManager;

import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;

public class WSDLManager implements WSDLManagerRetrieval {
    private Document wsdl;
    private ArrayList<Service> services;
    private HashMap<String, String> namespaces = new HashMap<String, String>();
    private HashMap<String, XSDManager> schemas = new HashMap<String, XSDManager>();
    private String targetNS;
    private String name;
    private XPath xPath;
    private String workingdir;
    private XSDManager xsdManager;

    public WSDLManager(String path) {

        try {
            this.namespaces.put("wsdl", "http://schemas.xmlsoap.org/wsdl/");
            this.load(path);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadNamespaces() throws XPathExpressionException {
        Node node = (Node) this.xPath.compile("/definitions").evaluate(this.wsdl, XPathConstants.NODE);
        NamedNodeMap attrMap = node.getAttributes();
        for (int i = 0; i < attrMap.getLength(); i++) {
            Node attrNode = attrMap.item(i);
            String nodeName = attrNode.getNodeName();
            String value = attrNode.getNodeValue();

            if (nodeName.startsWith("xmlns")) {
                this.namespaces.put(nodeName.replace("xmlns:", ""), value);
            } else if (nodeName.equals("targetNamespace")) {
                this.targetNS = value;
            } else if (nodeName.equals("name")) {
                this.name = value;
            }
        }
        this.xPath.setNamespaceContext(new NamespaceContext() {

            public Iterator getPrefixes(String namespaceURI) {
                return WSDLManager.this.namespaces.keySet().iterator();
            }

            public String getPrefix(String namespaceURI) {
                for (Entry entry : WSDLManager.this.namespaces.entrySet()) {
                    if (entry.getValue().equals(namespaceURI))
                        return (String) entry.getKey();
                }
                return null;
            }

            public String getNamespaceURI(String prefix) {
                return WSDLManager.this.namespaces.get(prefix);
            }
        });
    }

    private void load(String path) throws FileNotFoundException, SAXException, IOException,
            ParserConfigurationException, ClassNotFoundException, XPathException {
        File file = new File(path);
        this.workingdir = file.getParent();
        this.wsdl = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream(file));
        this.xPath = XPathFactory.newInstance().newXPath();
        this.loadNamespaces();
        this.loadSchema();
        this.loadServices();
        System.out.println("Done");

    }

    private boolean loadSchema()
            throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {

        NodeList types = (NodeList) this.xPath.compile("/definitions/types/schema").evaluate(this.wsdl,
                XPathConstants.NODESET);
        this.xsdManager = new XSDManager(this, this.workingdir, types);

        return true;
    }

    private void loadServices() throws XPathExpressionException {
        final NodeList ports = (NodeList) this.getXPath().compile("/definitions/service").evaluate(this.getWSDLFile(),
                XPathConstants.NODESET);
        this.services = new ArrayList<Service>() {
            {
                for (int i = 0; i < ports.getLength(); i++) {
                    Node serviceNode = ports.item(i);
                    Service port = new Service(WSDLManager.this, serviceNode);
                    add(port);
                }
            }
        };
    }

    public ArrayList<Service> getServices() {
        return this.services;
    }

    public Service getService(String serviceName) {
        for (Service service : this.services)
            if (serviceName.equals(service.getName()))
                return service;
        return null;
    }

    public Document getWSDLFile() {
        return this.wsdl;
    }

    public XSDManager getXSDManager() { // if (!schemas.containsKey(namespace))
        // if (!this.loadSchema(namespace))
        // return null;
        // return this.schemas.get(namespace);
        return this.xsdManager;
    }

    public XPath getXPath() {
        return this.xPath;
    }

    public String getTargetNameSpace() {
        return this.targetNS;
    }
}