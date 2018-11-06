package ne.wsdlparse.xsd;

import java.io.File;
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
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ne.wsdlparse.Utils;

public class XSDFile {
    Document xsd;
    private XPath xPath;
    private HashMap<String, String> namespaces = new HashMap<String, String>();
    private String targetNS;
    private ArrayList<XSDFile> includes = new ArrayList<XSDFile>();
    private ArrayList<XSDFile> imports = new ArrayList<XSDFile>();
    private HashMap<String, Node> inlineImports = new HashMap<String, Node>();

    private String filePath;
    private String workingdir;;
    private final static String NEW_ROOT = "/root/";
    private Boolean isRootModified = false;

    public XSDFile(String filePath, String namespace) throws FileNotFoundException, SAXException, IOException,
            ParserConfigurationException, XPathExpressionException {
        this.filePath = filePath;
        this.targetNS = namespace;
        File file = new File(filePath);
        this.workingdir = file.getParent();
        this.xsd = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream(file));
        this.load(filePath);

    }

    public XSDFile(String workingdir, NodeList schema)
            throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        this.workingdir = workingdir;

        this.xsd = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element root = this.xsd.createElement("root");
        this.xsd.appendChild(root);
        this.isRootModified = true;
        for (int i = 0; i < schema.getLength(); i++) {
            Node node = schema.item(i);
            node = this.xsd.importNode(node, true);
            root.appendChild(node);
        }
        this.load(filePath);
    }

    private void _import(String filePath, String namespace) throws FileNotFoundException, XPathExpressionException,
            SAXException, IOException, ParserConfigurationException {
        this.imports
                .add(new XSDFile(String.format(Locale.getDefault(), "%s/%s", this.workingdir, filePath), namespace));
    }

    private void include(String filePath) throws FileNotFoundException, SAXException, IOException,
            ParserConfigurationException, XPathExpressionException {
        this.includes.add(
                new XSDFile(String.format(Locale.getDefault(), "%s/%s", this.workingdir, filePath), this.targetNS));
    }

    private void load(String filePath) throws FileNotFoundException, SAXException, IOException,
            ParserConfigurationException, XPathExpressionException {

        this.xPath = XPathFactory.newInstance().newXPath();
        this.loadNamespaces();
        // load includes if any
        NodeList includes = (NodeList) this.xPath.compile(this.prepareXPath("schema/include")).evaluate(this.xsd,
                XPathConstants.NODESET);
        for (int i = 0; i < includes.getLength(); i++) {
            Node include = includes.item(i);
            this.include(Utils.getAttrValueFromNode(include, "schemaLocation"));
        }
        // load imports if any
        NodeList imports = (NodeList) this.xPath.compile(this.prepareXPath("schema/import")).evaluate(this.xsd,
                XPathConstants.NODESET);
        if (imports != null)
            this.imports = new ArrayList<XSDFile>();
        for (int i = 0; i < imports.getLength(); i++) {
            Node _import = imports.item(i);
            // String ns = Utils.getAttrValueFromNode(_import, "namespace");
            // this._import(Utils.getAttrValueFromNode(_import, "schemaLocation"), ns);

            String ns = Utils.getAttrValueFromNode(_import, "namespace");
            String schemaLocation = Utils.getAttrValueFromNode(_import, "schemaLocation");
            if (schemaLocation == null) {
                Node _schema = (Node) this.xPath.compile(
                        String.format(Locale.getDefault(), this.prepareXPath("schema[@targetNamespace='%s']"), ns))
                        .evaluate(this.xsd, XPathConstants.NODE);
                this.inlineImports.put(ns, _schema);
            } else {
                if (this.imports == null)
                    this.imports = new ArrayList<XSDFile>();
                this._import(schemaLocation, ns);
            }
        }
    }

    private String prepareXPath(String xpath) {
        if (!this.isRootModified) {
            if (xpath.startsWith(NEW_ROOT))
                xpath = xpath.replace(NEW_ROOT, "");
            return xpath;
        }
        if (xpath.startsWith(NEW_ROOT))
            return xpath;
        if (xpath.startsWith("/"))
            return NEW_ROOT.concat(xpath.substring(1));
        else
            return NEW_ROOT.concat(xpath);
    }

    private void loadNamespaces() throws XPathExpressionException {
        Node node = (Node) this.xPath.compile(this.prepareXPath("schema")).evaluate(this.xsd, XPathConstants.NODE);
        NamedNodeMap attrMap = node.getAttributes();
        for (int i = 0; i < attrMap.getLength(); i++) {
            Node attrNode = attrMap.item(i);
            String nodeName = attrNode.getNodeName();
            String value = attrNode.getNodeValue();

            if (nodeName.startsWith("xmlns")) {
                this.namespaces.put(nodeName.replace("xmlns:", ""), value);
            } else if (nodeName.equals("targetNamespace")) {
                this.targetNS = value;
            }
        }
        this.xPath.setNamespaceContext(new NamespaceContext() {

            public Iterator getPrefixes(String namespaceURI) {
                return XSDFile.this.namespaces.keySet().iterator();
            }

            public String getPrefix(String namespaceURI) {
                for (java.util.Map.Entry<String, String> entry : XSDFile.this.namespaces.entrySet()) {
                    if (entry.getValue().equals(namespaceURI))
                        return (String) entry.getKey();
                }
                return null;
            }

            public String getNamespaceURI(String prefix) {
                return XSDFile.this.namespaces.get(prefix);
            }

        });
    }

    public Object find(String xpath, Object source, QName returnType) throws XPathExpressionException {
        return this.xPath.compile(xpath).evaluate(source, returnType);
    }

    public Object find(String xpath, QName returnType) throws XPathExpressionException {
        String newxpath = this.prepareXPath(xpath);
        Object node = null;
        int i = 0;
        node = this.find(newxpath, this.xsd, returnType);
        if (node == null)

            node = this.findInChildren(xpath, returnType);
        return node;
    }

    private Object findInChildren(String xpath, QName returnType) throws XPathExpressionException {
        Object node = null;
        for (XSDFile file : this.includes) {
            node = file.find(xpath, returnType);
            if (node != null)
                return node;
        }

        for (XSDFile file : this.imports) {
            node = file.find(xpath, returnType);
            if (node != null)
                return node;
        }
        for (Entry<String, Node> entry : this.inlineImports.entrySet()) {
            node = this.find(xpath, entry.getValue(), returnType);
            if (node != null)
                return node;
        }

        return node;

    }

    public String getNamespaceURI(String prefix) {
        String ns = null;
        ns = this.xPath.getNamespaceContext().getNamespaceURI(prefix);
        if (ns != null)
            return ns;
        for (XSDFile file : this.includes) {
            ns = file.getNamespaceURI(prefix);
            if (ns != null)
                return ns;
        }
        for (XSDFile file : this.imports) {
            ns = file.getNamespaceURI(prefix);
            if (ns != null)
                return ns;
        }

        return null;
    }

}