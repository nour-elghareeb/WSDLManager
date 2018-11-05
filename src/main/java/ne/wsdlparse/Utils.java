package ne.wsdlparse;

import java.util.List;

import javax.xml.XMLConstants;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * Few simple utils to read DOM. This is originally from the Jakarta Commons
 * Modeler.
 *
 * @author Costin Manolache
 */
public class Utils {
    private static final String XMLNAMESPACE = "xmlns";

    public static Node getFirstXMLChild(Node node) {
        if (node == null)
            return null;
        node = node.getFirstChild();
        while (node != null && node.getNodeName().equals("#text")) {
            node = node.getNextSibling();
        }
        return node;
    }

    public static Node getNextXMLSibling(Node node) {
        node = node.getNextSibling();
        while (node != null && node.getNodeName().equals("#text")) {
            node = node.getNextSibling();
        }
        return node;
    }

    /**
     * Get all prefixes defined, up to the root, for a namespace URI.
     *
     * @param element
     * @param namespaceUri
     * @param prefixes
     */
    public static void getPrefixesRecursive(Element element, String namespaceUri, List<String> prefixes) {
        getPrefixes(element, namespaceUri, prefixes);
        Node parent = element.getParentNode();
        if (parent instanceof Element) {
            getPrefixesRecursive((Element) parent, namespaceUri, prefixes);
        }
    }

    /**
     * Get all prefixes defined on this element for the specified namespace.
     *
     * @param element
     * @param namespaceUri
     * @param prefixes
     */
    public static void getPrefixes(Element element, String namespaceUri, List<String> prefixes) {
        NamedNodeMap atts = element.getAttributes();
        for (int i = 0; i < atts.getLength(); i++) {
            Node node = atts.item(i);
            String name = node.getNodeName();
            if (namespaceUri.equals(node.getNodeValue())
                    && (name != null && (XMLNAMESPACE.equals(name) || name.startsWith(XMLNAMESPACE + ":")))) {
                prefixes.add(node.getPrefix());
            }
        }
    }

    public static String[] splitPrefixes(String value) {

        String[] splitArray = new String[2];
        if (value == null)
            return splitArray;
        else if (!value.contains(":")) {
            splitArray[0] = null;
            splitArray[1] = value;
            return splitArray;
        }
        return value.split(":");
    }

    public static String getParamWithPrefix(String prefix, String name) {
        String val = "";
        if (prefix != null) {
            val += prefix + ":";
        }
        val += name;
        return val;
    }

    public static String getAttrValueFromNode(Node node, String attrName) {
        if (node == null)
            return null;
        NamedNodeMap attrs = node.getAttributes();
        if (attrs == null)
            return null;
        Node attr = attrs.getNamedItem(attrName);
        if (attr == null)
            return null;

        return attr.getNodeValue();
    }
}
