package ne.wsdlparse.xsd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ne.wsdlparse.Utils;
import ne.wsdlparse.WSDLManagerRetrieval;

public class XSDManager {
    private XPath xPath;
    private WSDLManagerRetrieval wsdlManager;
    private HashMap<String, String> namespaces = new HashMap<String, String>();
    private ArrayList<XSDFile> includes = new ArrayList<XSDFile>();
    private ArrayList<XSDFile> imports;
    private HashMap<String, Node> inlineImports;
    private String targetNS;
    private String name;
    private Node inlineSchema;
    private String workingdir;
    private XSDFile xsd;

    private void _import(String filePath, String namespace) throws FileNotFoundException, SAXException, IOException,
            ParserConfigurationException, XPathExpressionException {
        this.imports.add(new XSDFile(String.format(Locale.getDefault(), "%s/%s", workingdir, filePath), namespace));
    }

    private void include(String filePath) throws FileNotFoundException, SAXException, IOException,
            ParserConfigurationException, XPathExpressionException {
        this.includes
                .add(new XSDFile(String.format(Locale.getDefault(), "%s/%s", workingdir, filePath), this.targetNS));
    }

    public XSDManager(WSDLManagerRetrieval wsdlManager, String workingdir, NodeList schemas)
            throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        this.workingdir = workingdir;
        // this.targetNS = Utils.getAttrValueFromNode(schemas, "targetNamespace");

        this.xsd = new XSDFile(workingdir, schemas);

        // load includes if any
        // NodeList includes = (NodeList)
        // wsdlManager.getXPath().compile("include").evaluate(schema,
        // XPathConstants.NODESET);
        // for (int i = 0; i < includes.getLength(); i++) {
        // Node include = includes.item(i);
        // this.include(Utils.getAttrValueFromNode(include, "schemaLocation"));
        // }
        // // load imports if any
        // NodeList imports = (NodeList)
        // wsdlManager.getXPath().compile("import").evaluate(schema,
        // XPathConstants.NODESET);

        // for (int i = 0; i < imports.getLength(); i++) {
        // Node _import = imports.item(i);
        // String ns = Utils.getAttrValueFromNode(_import, "namespace");
        // String schemaLocation = Utils.getAttrValueFromNode(_import,
        // "schemaLocation");
        // if (schemaLocation == null) {
        // Node _schema = (Node) wsdlManager
        // .getXPath().compile(String.format(Locale.getDefault(),
        // "/definitions/types/schema[@targetNamespace='%s']", ns))
        // .evaluate(wsdlManager.getWSDLFile(), XPathConstants.NODE);
        // if (this.inlineImports == null)
        // this.inlineImports = new HashMap<String, Node>();
        // this.inlineImports.put(ns, _schema);
        // } else {
        // if (this.imports == null)
        // this.imports = new ArrayList<XSDFile>();

        // }

        // }
        // this.inlineSchema = schema;
        // this.xPath = wsdlManager.getXPath();

    }

    public Object find(String xpath, Object source, QName returnType) throws XPathExpressionException {
        return this.xsd.find(xpath, source, returnType);
    }

    public Object find(String xpath, QName returnType) throws XPathExpressionException {
        return this.xsd.find(xpath, returnType);
        // Object node = null;
        // // search inline schema if any
        // node = this.find(xpath, this.inlineSchema, returnType);
        // // if not found, search includes if any..
        // if (node == null)
        // for (XSDFile file : this.includes) {
        // node = file.find(xpath, returnType);
        // if (node != null)
        // return node;
        // }
        // // if not found search inline imports if any...
        // for (Entry<String, Node> entry : this.inlineImports.entrySet()) {
        // Node schema = entry.getValue();
        // node = this.find(xpath, schema, returnType);
        // if (node != null)
        // return node;
        // }
        // // if not foumd, search external imports if any...
        // for (XSDFile file : this.imports) {
        // node = file.find(xpath, returnType);
        // if (node != null)
        // return node;
        // }
        // // return null.
        // return node;
    }
}